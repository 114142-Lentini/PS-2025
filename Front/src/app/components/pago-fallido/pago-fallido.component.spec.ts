import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PagoFallidoComponent } from './pago-fallido.component';

describe('PagoFallidoComponent', () => {
  let component: PagoFallidoComponent;
  let fixture: ComponentFixture<PagoFallidoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PagoFallidoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PagoFallidoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
