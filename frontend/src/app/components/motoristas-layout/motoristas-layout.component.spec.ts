import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MotoristasLayoutComponent } from './motoristas-layout.component';

describe('MotoristasLayoutComponent', () => {
  let component: MotoristasLayoutComponent;
  let fixture: ComponentFixture<MotoristasLayoutComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MotoristasLayoutComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MotoristasLayoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
