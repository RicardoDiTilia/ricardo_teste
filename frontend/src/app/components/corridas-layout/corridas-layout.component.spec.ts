import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CorridasLayoutComponent } from './corridas-layout.component';

describe('CorridasLayoutComponent', () => {
  let component: CorridasLayoutComponent;
  let fixture: ComponentFixture<CorridasLayoutComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CorridasLayoutComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CorridasLayoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
