import { TestBed } from '@angular/core/testing';

import { MyMonitoringServiceService } from './my-monitoring-service.service';

describe('MyMonitoringServiceService', () => {
  let service: MyMonitoringServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MyMonitoringServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
