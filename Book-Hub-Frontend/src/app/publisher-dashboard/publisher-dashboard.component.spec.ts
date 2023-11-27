import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PublisherDashboardComponent } from './publisher-dashboard.component';

describe('PublisherDashboardComponent', () => {
  let component: PublisherDashboardComponent;
  let fixture: ComponentFixture<PublisherDashboardComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PublisherDashboardComponent]
    });
    fixture = TestBed.createComponent(PublisherDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
