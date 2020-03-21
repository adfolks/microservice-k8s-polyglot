import { Injectable } from '@angular/core';
import { Observable } from "rxjs";

@Injectable()
export class GeolocationService {

  constructor() { }

  getCoordinates():  Observable<any> {
    return Observable.create(observer => {
      if (window.navigator && navigator.geolocation) {
        window.navigator.geolocation.getCurrentPosition((position) => {
            observer.next(position);
            observer.complete();
          },
            (error) => observer.error(error)
         );
        } else {
          observer.error('Unsupported browser');
        }
      });
    }
}
