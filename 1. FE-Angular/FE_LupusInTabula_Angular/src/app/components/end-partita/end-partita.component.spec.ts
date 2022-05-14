import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EndPartitaComponent } from './end-partita.component';

describe('EndPartitaComponent', () => {
  let component: EndPartitaComponent;
  let fixture: ComponentFixture<EndPartitaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EndPartitaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EndPartitaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
