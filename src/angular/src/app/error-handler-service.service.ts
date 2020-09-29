import { Injectable, ErrorHandler } from '@angular/core';
import { MyMonitoringServiceService } from './my-monitoring-service.service';

@Injectable({
  providedIn: 'root'
})
export class ErrorHandlerService extends ErrorHandler {

  constructor(private myMonitoringService: MyMonitoringServiceService) {
      super();
  }

  handleError(error: Error) {
      this.myMonitoringService.logException(error); // Manually log exception
  }
}
