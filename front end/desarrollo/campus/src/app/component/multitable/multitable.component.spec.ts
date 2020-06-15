import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MultitableComponent } from './multitable.component';

describe('MultitableComponent', () => {
  let component: MultitableComponent;
  let fixture: ComponentFixture<MultitableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MultitableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MultitableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
