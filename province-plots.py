import requests

local_api_url = 'http://127.0.0.1:8080/api/main/'

local_url = local_api_url + '/provinces/'

response = requests.get('http://127.0.0.1:8080/api/main/provinces')
#print(response)

#print(response.json())

provs = []
ids = []
arg = {}

for item in response.json():
	print(item)
	provs += [item['provName']]
	ids += [item['id']]

print(provs)
print(ids)

provs_json = []

X=[]
Y=[]

# 'http://127.0.0.1:8080/api/main/deathsByDay'
for p in provs:
    x=[]
    y=[]
    response = requests.get('http://127.0.0.1:8080/api/main/deathsByProvByDay/' + p)
    for i in response.json():
        x+=[i['fecha_fallecimiento']]
        y+=[i['aux']]
    #####################
    import plotly.graph_objects as go
    from plotly.subplots import make_subplots
    def plot(fig, x, y, row=1, col=1):
      fig.add_trace(go.Scatter(x=x, y=y, line=dict(color='rgb(0,100,80)'),hovertemplate = '%{x} - Razon: %{y}<extra></extra>', showlegend=False), row=row, col=col)
    fig_arg = make_subplots(rows=1, cols=1)
    plot(fig_arg, x, y)
    fig_arg.update_layout(title={ 'text': 'Fallecimientos por Covid - ' + p, 'y':0.9, 'x':0.5, 'xanchor': 'center', 'yanchor': 'top'}, font=dict(family="Courier New, monospace", size=18))
    config = {'displayModeBar': False}
    fig_arg.show(config=config)
    #####################
