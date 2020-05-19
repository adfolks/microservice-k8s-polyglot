import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { HeaderComponent } from './header/header.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';
import { GhostListComponent } from './home/ghost-list/ghost-list.component';

import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatCardModule } from '@angular/material/card';
import { MatInputModule } from '@angular/material/input';
import { ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { NewsModalComponent } from './news-modal/news-modal.component';
import { MatDialogModule } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
import { TimeComponent } from './time/time.component';
import { WeatherTodayComponent } from './weather-today/weather-today.component';
import { GeolocationService } from './geolocation.service';
import { WeatherService } from './weather.service';
import { AdsComponent } from './ads/ads.component';
import { CarouselModule } from 'ngx-bootstrap';
import { ShopComponent } from './shop/shop.component';
import { ShoppingCartComponent } from './shopping-cart/shopping-cart.component';



@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AboutComponent,
    HeaderComponent,
    NavbarComponent,
    FooterComponent,
    NewsModalComponent,
    GhostListComponent,
    TimeComponent,
    WeatherTodayComponent,
    AdsComponent,
    ShopComponent,
    ShoppingCartComponent,
  ],
  imports: [
   
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatCardModule,
    MatInputModule,
    CarouselModule.forRoot(),
    ReactiveFormsModule,
    MatFormFieldModule,
    MatSelectModule,
    MatDialogModule,
    MatButtonModule,

  ],
  entryComponents: [NewsModalComponent],
  providers: [GeolocationService, WeatherService, HttpClientModule,

],
  bootstrap: [AppComponent]
})
export class AppModule { }
