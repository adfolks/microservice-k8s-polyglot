import { Component, OnInit, Input, Output ,EventEmitter} from '@angular/core';
// import { EventEmitter } from 'protractor';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {
  @Input() checkData:[];
  @Output() isCheckout: EventEmitter<boolean> = new EventEmitter();
  // @Input() data:[];

  constructor() { }

  ngOnInit() {
    // console.log(this.data);
    // console.log(this.checkData)

  }

  removeCart(article){
    // const index = this.checkData.indexOf(article.toString());
    // if (index > -1) {
    //   this.checkData.splice(index, 1);
    // }
    alert(article.id)
    delete this.checkData[article];

  }

  isChecout(){
    alert("Checked out successfully")
    this.isCheckout.emit(false);
  }

  isCart(){
    this.isCheckout.emit(false);
  }

}
