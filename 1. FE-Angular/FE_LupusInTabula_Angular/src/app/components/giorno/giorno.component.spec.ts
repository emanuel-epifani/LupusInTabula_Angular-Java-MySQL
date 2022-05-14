import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GiornoComponent } from './giorno.component';

describe('GiornoComponent', () => {
  let component: GiornoComponent;
  let fixture: ComponentFixture<GiornoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GiornoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GiornoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
