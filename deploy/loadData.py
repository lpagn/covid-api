import pandas as pd
from sqlalchemy import create_engine
from datetime import date

import psycopg2 as postgres
from psycopg2.extensions import ISOLATION_LEVEL_AUTOCOMMIT

import wget

import os

import socket

def fetchData():
	print("UPDATING DATA")
	filename = 'example.csv'
	if os.path.exists(filename):
		os.remove(filename)

	url = 'https://sisa.msal.gov.ar/datos/descargas/covid-19/files/Covid19Casos.csv'
	print("FETCHING DATA")
	wget.download('https://raw.githubusercontent.com/TomasBacigalupo/infovis/gh-pages/stravaActivitiesAno.csv','./postgresql')
	print("\nDATA FETCHED")

def save_data_copy():


	print("UPDATING DATA")
	filename = 'Covid19Casos.csv'
	if os.path.exists(filename):
		os.remove(filename)

	url = 'https://sisa.msal.gov.ar/datos/descargas/covid-19/files/Covid19Casos.csv'
	print("FETCHING DATA")
	wget.download('https://raw.githubusercontent.com/TomasBacigalupo/infovis/gh-pages/stravaActivitiesAno.csv','./postgresql')
	print("\nDATA FETCHED")


	conn = postgres.connect("host= 192.168.1.104 dbname=docker user=docker password=docker")

	conn.set_isolation_level(ISOLATION_LEVEL_AUTOCOMMIT)


	cursor = conn.cursor()

	file = open('data_update.sql', mode='r')

	update_script = file.read()

	file.close()

	cursor.execute("DROP TABLE IF EXISTS covid;")

	print("VACUUMING DB")
	os.system("vacuumdb --full infovis")
	print("DB VACUUMED")

	print("WRITING TO DATABASE")

	cursor.execute(update_script)

	print("UPDATE COMPLETED")

	cursor.close()
	conn.close()

# fetchData() call save_data_copy() for update

