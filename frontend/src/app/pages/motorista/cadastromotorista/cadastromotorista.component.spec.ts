import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastromotoristaComponent } from './cadastromotorista.component';

describe('CadastromotoristaComponent', () => {
  let component: CadastromotoristaComponent;
  let fixture: ComponentFixture<CadastromotoristaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CadastromotoristaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CadastromotoristaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
