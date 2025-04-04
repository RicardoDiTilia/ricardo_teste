import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultarcorridaComponent } from './consultarcorrida.component';

describe('ConsultarcorridaComponent', () => {
  let component: ConsultarcorridaComponent;
  let fixture: ComponentFixture<ConsultarcorridaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ConsultarcorridaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConsultarcorridaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
