import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import config from './../../config.js';
import { MatDialog } from '@angular/material/dialog';


@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.css'],
})
export class ShopComponent implements OnInit {
  showResultsDiv: boolean = false;
  data :any;
  itemCount=0;
  adData = [];
  ghosts = [];

  constructor(
    private httpClient: HttpClient, public dialog: MatDialog) { }

  makeTheRequestAndGetData(formValue) {
    return this.httpClient.get(config.cartUrl).subscribe((data) => {
      console.log(data)
      this.data = data;
      // this.adData = data['ads']
      this.showResultsDiv = false;
    });

  }

  ngOnInit() {
    this.ghosts = new Array(30);
    this.showResultsDiv = true;
    this.makeTheRequestAndGetData('');
  }

  public addProductToCart(product:any): void {
    this.itemCount++;
  }
  emptyCart(){
    this.itemCount=0;
  }

}
