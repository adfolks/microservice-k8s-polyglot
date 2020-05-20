import { Component, OnInit, Input } from '@angular/core';
import { CarouselConfig } from 'ngx-bootstrap/carousel';
import { HttpClient } from '@angular/common/http';
import config from './../../config.js';

@Component({
  selector: 'app-ads',
  templateUrl: './ads.component.html',
  styleUrls: ['./ads.component.css']
})
export class AdsComponent implements OnInit {
  adData:any;
  ads:[];

  makeTheRequestAndGetData(formValue) {

    return this.httpClient.get(config.adsUrl).subscribe((data) => {
      console.log(data)
      // this.data = data['news'];
     
      this.adData = data;
      for(var i=0;i<this.adData.length;i++){
        var image="http://35.173.254.49:1337"+this.adData[i].image[0].url
        this.adData[i].image[0].url=image;
        // this.ads.push(
            // {
            //   this.adData[i].title,
            //   "image":
            // image
            // } 

        // )
      }

    });

  }

  constructor(private httpClient: HttpClient) { }
  ngOnInit() {
    this.makeTheRequestAndGetData('');

    // setTimeout( () => { console.log(this.adData) }, 2000 );
    
  }


}
