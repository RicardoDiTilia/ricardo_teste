import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultarpassageiroComponent } from './consultarpassageiro.component';

describe('ConsultarpassageiroComponent', () => {
  let component: ConsultarpassageiroComponent;
  let fixture: ComponentFixture<ConsultarpassageiroComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ConsultarpassageiroComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConsultarpassageiroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
