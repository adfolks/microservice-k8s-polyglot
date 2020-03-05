var express = require('express');
var app = express();
app.get('/', function(req, res) {
    let data = require("../adservice/data.json")
    res.send(data);
});
app.get('/1', function(req, res) {
    let data = require("../adservice/data.json")
    console.log(data[0]);
    res.send(data[1]);
});
app.listen(3000, function() {
    console.log('Example app listening on port 3000!');
});