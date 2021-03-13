import requests

local_api_url = 'http://127.0.0.1:8080/api/main/'

local_url = local_api_url + '/deathsByDay/'

response = requests.get('http://127.0.0.1:8080/api/main/deathsByDay')

x = []
y = []
arg = {}

for item in response.json():
	print(item)
	x += [item['fecha_fallecimiento']]
	y += [item['aux']]

#####################

import plotly.graph_objects as go
from plotly.subplots import make_subplots

def plot(fig, x, y, row=1, col=1):
  fig.add_trace(go.Scatter(x=x, y=y, line=dict(color='rgb(0,100,80)'),hovertemplate = '%{x} - Razon: %{y}<extra></extra>', showlegend=False), row=row, col=col)

fig_arg = make_subplots(rows=1, cols=1)

plot(fig_arg, x, y)

fig_arg.update_layout(title={ 'text': 'Fallecimientos por Covid - Argentina', 'y':0.9, 'x':0.5, 'xanchor': 'center', 'yanchor': 'top'}, font=dict(family="Courier New, monospace", size=18))
config = {'displayModeBar': False}
fig_arg.show(config=config)

#####################
