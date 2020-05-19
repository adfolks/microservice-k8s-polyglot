import { Component, OnInit, Input } from '@angular/core';
import { CarouselConfig } from 'ngx-bootstrap/carousel';

@Component({
  selector: 'app-ads',
  templateUrl: './ads.component.html',
  styleUrls: ['./ads.component.css']
})
export class AdsComponent implements OnInit {
  @Input() adData:[];

  constructor() { }

  ngOnInit() {

    setTimeout( () => { console.log(this.adData) }, 2000 );
    
  }


}
