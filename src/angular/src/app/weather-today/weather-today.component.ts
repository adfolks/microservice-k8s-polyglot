import { WeatherService } from './../weather.service';
import { GeolocationService } from './../geolocation.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-weather-today',
  templateUrl: './weather-today.component.html',
  styleUrls: ['./weather-today.component.css']
})
export class WeatherTodayComponent implements OnInit {
  latitude: number;
  longitude: number;
  weatherCondition: string;
  cityName: string;
  errorMessage: string;
  icon:string;
  constructor(private _geolocationService: GeolocationService,
              private _weatherService: WeatherService
  ) { }

  ngOnInit() {
      this._geolocationService.getCoordinates().subscribe(result => {
        console.log(result);
        this.latitude = result.coords.latitude;
        this.longitude = result.coords.longitude;
        this._weatherService.getTodayWeather(this.latitude, this.longitude).subscribe(weatherData => {
         this.weatherCondition = weatherData.list[0].weather[0].description;
         this.icon= "http://openweathermap.org/img/wn/"+weatherData.list[0].weather[0].icon+".png";
            this.cityName = weatherData.city.name;
        },
         error => this.errorMessage = error
        );
      });
  }
}
