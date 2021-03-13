import pandas as pd
from sqlalchemy import create_engine
from datetime import date

import psycopg2 as postgres
from psycopg2.extensions import ISOLATION_LEVEL_AUTOCOMMIT

import wget

import os

import socket

print("SAVE DATA")
def save_data_copy():
	conn = postgres.connect("host= 192.168.1.121 dbname=docker user=postgres password=postgres")

	conn.set_isolation_level(ISOLATION_LEVEL_AUTOCOMMIT)


	cursor = conn.cursor()

	file = open('data_update.sql', mode='r')

	update_script = file.read()

	file.close()

	cursor.execute("DROP TABLE IF EXISTS covid;")

# 	print("VACUUMING DB")
# 	os.system("vacuumdb --full infovis")
# 	print("DB VACUUMED")

	print("WRITING TO DATABASE")

	cursor.execute(update_script)

	print("UPDATE COMPLETED")

	cursor.close()
	conn.close()

save_data_copy()