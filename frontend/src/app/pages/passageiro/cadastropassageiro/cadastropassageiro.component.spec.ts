import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastropassageiroComponent } from './cadastropassageiro.component';

describe('CadastropassageiroComponent', () => {
  let component: CadastropassageiroComponent;
  let fixture: ComponentFixture<CadastropassageiroComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CadastropassageiroComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CadastropassageiroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
