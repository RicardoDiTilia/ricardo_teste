import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PassageirosLayoutComponent } from './passageiros-layout.component';

describe('PassageirosLayoutComponent', () => {
  let component: PassageirosLayoutComponent;
  let fixture: ComponentFixture<PassageirosLayoutComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PassageirosLayoutComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PassageirosLayoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
