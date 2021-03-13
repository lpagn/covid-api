import flask
from flask import request, jsonify
import time
import atexit
from apscheduler.schedulers.background import BackgroundScheduler

from loadData import *

import sys

import json

def api_save_data():
	save_data_copy()

if(len(sys.argv)>1):
	if(sys.argv[1] == 'update'):
		print("Hello, World!")
		api_save_data()
