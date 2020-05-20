
from confluent_kafka import Producer
import sys
import json
import random
import time
import os

if __name__ == '__main__':
    if len(sys.argv) != 2:
        sys.stderr.write('Usage: %s <topic>\n' % sys.argv[0])
        sys.exit(1)
    topic = sys.argv[1]
    key = os.environ['EVENTHUB_CONNECTION']
    conf = {
        'bootstrap.servers': 'ecom-data.servicebus.windows.net:9093', #replace
        'security.protocol': 'SASL_SSL',
        'ssl.ca.location': '/usr/lib/ssl/certs/ca-certificates.crt',
        'sasl.mechanism': 'PLAIN',
        'sasl.username': '$ConnectionString',
        'sasl.password': key,          #replace
        'client.id': 'python-example-producer'
    }

    p = Producer(**conf)

    while True:
        try:
            data = {}
            data['product_id'] = random.randint(1,15)
            data['product_quantity'] = random.randint(1,100)
            data = json.dumps(data)
            p.produce(topic, data)
            time.sleep(2)
        except BufferError as e:
            sys.stderr.write('%% Local producer queue is full (%d messages awaiting delivery): try again\n' % len(p))
        p.poll(0)
