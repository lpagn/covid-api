import requests
import pandas as pd
import altair as alt

local_api_url = 'http://127.0.0.1:8080/api/main/'

local_url = local_api_url + '/classify/'

response = requests.get('http://127.0.0.1:8080/api/main/casesProv')
print(response)

print(response.json())

name = []
aux = []
arg = {}

for item in response.json():
	print(item)
	name += [item['carga_provincia_nombre']]
	aux += [item['aux']]

print(name)
print(aux)

df = pd.DataFrame({'name':name, 'aux':aux})

print(df)
chart = alt.Chart(df,title="Casos Por Provincia").mark_bar().encode(
    y='name',
    x='aux'
)
chart.show()

response = requests.get('http://127.0.0.1:8080/api/main/deathsProv')
print(response)

print(response.json())

name = []
aux = []
arg = {}

for item in response.json():
	print(item)
	name += [item['carga_provincia_nombre']]
	aux += [item['aux']]

print(name)
print(aux)

df = pd.DataFrame({'name':name, 'aux':aux})

print(df)
chart = alt.Chart(df,title="Muertos Por Provincia").mark_bar().encode(
    y='name',
    x='aux'
)
chart.show()