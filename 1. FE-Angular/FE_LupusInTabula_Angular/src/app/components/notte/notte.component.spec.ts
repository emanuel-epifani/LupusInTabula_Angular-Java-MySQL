import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NotteComponent } from './notte.component';

describe('NotteComponent', () => {
  let component: NotteComponent;
  let fixture: ComponentFixture<NotteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NotteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NotteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
