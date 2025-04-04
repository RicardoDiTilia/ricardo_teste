import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrarcorridaComponent } from './registrarcorrida.component';

describe('RegistrarcorridaComponent', () => {
  let component: RegistrarcorridaComponent;
  let fixture: ComponentFixture<RegistrarcorridaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RegistrarcorridaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegistrarcorridaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
