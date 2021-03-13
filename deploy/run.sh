#!/bin/bash

python3 fetch.py

docker-compose up -d

python3 save_data.py

