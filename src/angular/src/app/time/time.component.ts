import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-time',
  templateUrl: './time.component.html',
  styleUrls: ['./time.component.css']
})
export class TimeComponent implements OnInit {
  d:Date;
  e:any;
  dateData:any;

  constructor() { }

  ngOnInit() {
    this.d = new Date();
    this.e = this.formatDate(this.d);
  }
  formatDate(date) {
    var days = ['Sunday','Monday','Tuesday','Wednesday','Thursday','Friday','Saturday'];
var months = ['January','February','March','April','May','June','July','August','September','October','November','December'];

    var day = days[ date.getDay() ];
    var month = months[ date.getMonth() ];
    var hours = date.getHours();
    var minutes = date.getMinutes();
    var ampm = hours >= 12 ? 'pm' : 'am';
    hours = hours % 12;
    hours = hours ? hours : 12; // the hour '0' should be '12'
    minutes = minutes < 10 ? '0'+minutes : minutes;
    var strTime = hours + ':' + minutes + ' ' + ampm;
    this.dateData={
      date:day + " ," + date.getDate() +" "+ month +" "+ date.getFullYear(),
      tym:strTime
    }
    return  this.dateData;
  }

}
