import requests

local_api_url = 'http://127.0.0.1:8080/api/main/'

local_url = local_api_url + '/provinces/'

response = requests.get('http://127.0.0.1:8080/api/main/provinces')
#print(response)
provinces = response.json()
#print(response.json())

provs = []
ids = []
provs_json = []
arg = {}

for item in response.json():
	print(item)
	provs += [item['provName']]
	ids += [item['id']]

print(provs)

#####################

for p in provs:
    print(local_api_url + 'province/' + p +  '/summary')
    local_url = local_api_url + 'province/' + p +  '/summary'
    response = requests.get(local_url)
    provs_json += [response.json()]
    #print(response)
    #print(response.json)
    for item in response.json():
#         print(item)
#         for elem in item:
#             print( '[%s]:[%s]' % (elem , item[elem]) )
        for item in response.json():
            if item['date'] in arg:
              arg[item['date']]['deaths_acum'] = arg[item['date']]['deaths_acum'] + item['deaths_acum']
              arg[item['date']]['cases_acum'] = arg[item['date']]['cases_acum'] + item['cases_acum']
            else:
              arg[item['date']] = {}
              arg[item['date']]['date'] = item['date']
              arg[item['date']]['deaths_acum'] = item['deaths_acum']
              arg[item['date']]['cases_acum'] = item['cases_acum']


#####################

import plotly.graph_objects as go
from plotly.subplots import make_subplots

def plot(fig, x, y, row=1, col=1):
  fig.add_trace(go.Scatter(x=x, y=y, line=dict(color='rgb(0,100,80)'),hovertemplate = '%{x} - Razon: %{y}<extra></extra>', showlegend=False), row=row, col=col)

fig_arg = make_subplots(rows=1, cols=1)

x = [d['date'] for d in arg.values()]
y = [(d['deaths_acum']/d['cases_acum'])*100 if d['cases_acum'] != 0 else 0 for d in arg.values()]

plot(fig_arg, x, y)

fig_arg.update_layout(title={ 'text': 'Razon de letalidad de los casos de Argentina', 'y':0.9, 'x':0.5, 'xanchor': 'center', 'yanchor': 'top'}, font=dict(family="Courier New, monospace", size=18))
config = {'displayModeBar': False}
fig_arg.show(config=config)

#####################

import altair as alt
import pandas as pd

charts = {}
nearest = alt.selection(type='single', nearest=True, on='mouseover', fields=['fecha'], empty='none')

#print(provs_json)
# for p in provs_json:
#     print('--------------')
#     print(p)
#     print('--------------')

print('======================================')

#print(enumerate(provs_json)

for index, p in enumerate(provs_json):
  name = provs[index]
  slug = ids[index]
  dates = [d['date'] for d in p]
  rate = [(d['deaths_acum']/d['cases_acum'])*100 if d['cases_acum'] != 0 else 0 for d in p]
  df = pd.DataFrame({'fecha':dates,'razon':rate})

  line = alt.Chart(df).mark_line(color='#009999').encode(x=alt.X('fecha:T', title=''), y=alt.Y('razon:Q', title='Razón de letalidad'))
  selectors = alt.Chart(df).mark_point().encode(x='fecha:T', opacity=alt.value(0)).add_selection(nearest)
  points = line.mark_point().encode(opacity=alt.condition(nearest, alt.value(1), alt.value(0)))
  text = line.mark_text(align='left', dx=5, dy=-5).encode(text=alt.condition(nearest, 'razon:Q', alt.value(' ')))
  rules = alt.Chart(df).mark_rule(color='gray').encode(x='fecha:T').transform_filter(nearest)
  graph = alt.layer(line, selectors, points, text, rules).properties(width=500, height=200, title=name)
  charts[str(slug).zfill(2)] = graph

array_charts = list(charts.values())

def make_hcc(row_of_charts):
    hconcat = [chart for chart in row_of_charts]
    hcc = alt.HConcatChart(hconcat=hconcat)
    return hcc

rows_of_charts = [array_charts[i:i+3] for i in range(0, len(array_charts), 3)]
vconcat = [make_hcc(r) for r in rows_of_charts]
compound_chart = alt.VConcatChart(vconcat=vconcat).configure_axisX(grid=True).configure_axisY(grid=True)
compound_chart.properties(title='Razon de letalidad de los casos por provincia')
compound_chart.show()
#altair_viewer.show(compound_chart)