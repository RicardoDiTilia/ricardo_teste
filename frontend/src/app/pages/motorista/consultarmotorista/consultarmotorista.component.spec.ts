import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultarmotoristaComponent } from './consultarmotorista.component';

describe('ConsultarmotoristaComponent', () => {
  let component: ConsultarmotoristaComponent;
  let fixture: ComponentFixture<ConsultarmotoristaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ConsultarmotoristaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConsultarmotoristaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
