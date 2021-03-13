print("FETCH")
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
	wget.download(url,'./postgresql')
	print("\nDATA FETCHED")

fetchData()
