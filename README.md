# README #

##Tomás Bacigalupo, 58490 
##Lucio Pagni, 58571

### What is this repository for? ###

* COVID-API InfoVis ITBA
* 1.0.0

###Visualisations

* plots.py
* python3 classification.py
* python3 consume-api.py

### How do I get set up? ###

* For fast develop we use docker containers. The deploy folder contains set up of DB, DB admin, Tomcat server.
* Configuration: run loadData.py script to fetch Arg COVID dataset and set your private IP in WebConfig 
* Dependencies: run mvn clean install to fetch all dependencies
* Database configuration: run docker-compose up -d to run Database container
* Deployment instructions: run docker-comop up -d to run tomcat server and deploy the app

### Contribution guidelines ###

* BackEnd: PAW good practices
* FrontEnd template: https://startbootstrap.com/template/sb-admin
* FrontEnd charts: chart.js

### Who do I talk to? ###

* tbacigalupo@itba.edu.ar
* lpagni@itba.edu.ar

# covid-api
# covid-api
