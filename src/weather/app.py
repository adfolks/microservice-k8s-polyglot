from flask import Flask
from weather import get_weather as gw
app = Flask(__name__)

@app.route('/')
def hello():
    return gw.get_weather()
if __name__ == '__main__':
    app.run(port=5000,debug=True)