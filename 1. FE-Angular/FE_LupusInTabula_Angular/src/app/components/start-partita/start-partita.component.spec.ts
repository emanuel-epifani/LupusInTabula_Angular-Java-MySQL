import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StartPartitaComponent } from './start-partita.component';

describe('StartPartitaComponent', () => {
  let component: StartPartitaComponent;
  let fixture: ComponentFixture<StartPartitaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StartPartitaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StartPartitaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
