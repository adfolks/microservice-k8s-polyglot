import { ChangeDetectionStrategy, Component, OnDestroy, OnInit } from "@angular/core";
// import { Product } from "../models/product.model";
import { ShoppingCart } from "../models/shopping-cart.model";
// import { ProductsDataService } from "../services/products.service";
import { ShoppingCartService } from "../services/shopping-cart.service";
import { Observable } from "rxjs";
import { Subscription } from "rxjs";

@Component({
  changeDetection: ChangeDetectionStrategy.OnPush,
  selector: "app-shopping-cart",
  templateUrl: "./shopping-cart.component.html",
})
export class ShoppingCartComponent implements OnInit{
  // public products: Observable<Product[]>;
  public cart: Observable<ShoppingCart>;
  public itemCount: number;

  private cartSubscription: Subscription;

  public constructor(
    // private productsService: ProductsDataService,
                     private shoppingCartService: ShoppingCartService
                     ) {
  }

  public emptyCart(): void {
    this.shoppingCartService.empty();
  }

  public ngOnInit(): void {
    // this.products = this.productsService.all();
      // this.cart = this.shoppingCartService.get();
      // console.log("kk")
    // this.cartSubscription = this.cart.subscribe((cart) => {
    //   this.itemCount = cart.items.map((x) => x.quantity).reduce((p, n) => p + n, 0);
    // });

    // this.itemCount=this.shoppingCartService.itemCount;
  }

  public ngOnDestroy(): void {
    // if (this.cartSubscription) {
    //   this.cartSubscription.unsubscribe();
    // }
  }
}
