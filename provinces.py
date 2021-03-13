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