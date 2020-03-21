import configparser
from utility import logger

log = logger.get_logger()
config = configparser.ConfigParser()
CONFIG_LOCATION = './config.cfg'

def config_init():
    try:
        config.read(CONFIG_LOCATION)
        log.info('Loading configuration')
        return config
    except Exception as e:
        log.error(str(e))

def get_api_key():
    _config = config_init()
    apikey = _config['OpenAPI'].get('key')
    return apikey

def get_city_id():
    _config = config_init()
    city_id = _config['OpenAPI'].get('city_id')
    return city_id
    