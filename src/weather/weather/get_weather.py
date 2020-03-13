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

def get_weather(city_id):
    result = {}
    if city_id == None:
        city_id = configparse.get_city_id()
    querystring = {"id":str(city_id),"appid":str(configparse.get_api_key())}
    response = requests.request("GET", URL, params=querystring)
    response_json = json.loads(response.text)
    result['cityName'] = response_json['name']
    result['code'] = str(response.status_code)
    result['countryName'] = response_json['sys']['country']
    result['weatherMain'] = response_json['weather'][0]['main']
    result['feelsLike'] = response_json['main']['feels_like']
    result['temp'] = response_json['main']['temp']
    return result