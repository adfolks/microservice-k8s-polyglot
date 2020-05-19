import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { HttpClient , HttpParams } from '@angular/common/http';
import config from './config.js';
@Injectable()
export class WeatherService {

  constructor(private http: HttpClient) { }

  getTodayWeather(lat, long ): Observable<any> {
     const param: any = {'lat': lat, 'lon': long, 'APPID': config.APPID};
     return this.http.get(config.url, { params: param });
  } 
}
  