import configparser
import logging
from utility import logger, configparse
import sys
import json
import requests

URL = "http://api.openweathermap.org/data/2.5/weather"


log = logger.get_logger()
# config = configparse.get_config()
log.info('Configuration loaded')

def get_weather():
    querystring = {"id":str(configparse.get_city_id()),"appid":str(configparse.get_api_key())}
    response = requests.request("GET", URL, params=querystring)
    result = json.loads(response.text)
    result['code'] = response.status_code
    return result