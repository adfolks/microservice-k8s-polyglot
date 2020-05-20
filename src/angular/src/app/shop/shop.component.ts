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
  showCheckout:boolean=false;
  data :any;
  itemCount=0;
  occurrences:any;
  adData = [];
  ghosts = [];
  checkoutItems = [];
  checkoutData=[];

  constructor(
    private httpClient: HttpClient, public dialog: MatDialog) { }

  makeTheRequestAndGetData(formValue) {
    return this.httpClient.get(config.cartUrl).subscribe((data) => {
      // console.log(data)
      this.data = data;
      // this.adData = data['ads']
      this.showResultsDiv = false;

    });

  }

  countChangedHandler(count) {
    this.showCheckout = count;
    // console.log(count);
  }

  ngOnInit() {
    this.ghosts = new Array(30);
    this.showResultsDiv = true;
    this.makeTheRequestAndGetData('');
  }

  public addProductToCart(product:any): void {
    this.itemCount++;
  
  // if(this.checkoutItems.indexOf(product.id) === -1) {
    this.checkoutItems.push(product.id);
    console.log(this.checkoutItems);
  // }

  }
  emptyCart(){
    this.itemCount=0;
    this.checkoutItems=[];
  }

  removeProductFromCart(product){
    this.checkoutItems = this.checkoutItems.filter(x => x !== product.id);
    this.itemCount=this.checkoutItems.length;

  }

  checkAvailabilty(id){
    alert("10 pieces")
  }


  openDialog() {
    this.showCheckout=true;
    this.occurrences = { };
    for (var i = 0, j = this.checkoutItems.length; i < j; i++) {
   this.occurrences[this.checkoutItems[i]] = (this.occurrences[this.checkoutItems[i]] || 0) + 1;
 
  }
    // console.log(this.occurrences);

    var keys = [];
    for(var k in this.occurrences) keys.push(k);

    // console.log(keys)

    for(var i=0;i<this.data.length;i++){
      // console.log(this.data[i].id)
     if(keys.includes((this.data[i].id).toString())){
        // console.log("ksk")
        this.checkoutData.push(
          {
            "occurence":this.occurrences[(this.data[i].id).toString()],
            "id":this.data[i].id,
            "name":this.data[i].name,
            "description":this.data[i].description,
            "image":this.data[i].image
          }
        )

      }
    
    }
}



  public productInCart(product): boolean {
      if(this.checkoutItems.indexOf(product.id) === -1) {
        return false
      }
      return true;

  }

}
