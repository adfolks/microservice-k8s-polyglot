var express = require('express');
var app = express();
app.get('/', function(req, res) {
    let data = require("/usr/src/app/data.json")
    res.send(data);
});
app.get('/1', function(req, res) {
    let data = require("/usr/src/app/data.json")
    console.log(data[0]);
    res.send(data[1]);
});
app.listen(8080, function() {
    console.log('AdService is listening on port 8080!');
});