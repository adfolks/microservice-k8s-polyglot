import { TestBed } from '@angular/core/testing';

import { ErrorHandlerServiceService } from './error-handler-service.service';

describe('ErrorHandlerServiceService', () => {
  let service: ErrorHandlerServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ErrorHandlerServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
