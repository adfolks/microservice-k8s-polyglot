from flask import Flask,request
from weather import get_weather as gw
app = Flask(__name__)

@app.route('/get-weather',methods=['GET'])
def hello():
    city_id = request.args.get('id')
    return gw.get_weather(city_id)
if __name__ == '__main__':
    app.run(host='0.0.0.0',port=5000,debug=True)