import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PagoPendienteComponent } from './pago-pendiente.component';

describe('PagoPendienteComponent', () => {
  let component: PagoPendienteComponent;
  let fixture: ComponentFixture<PagoPendienteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PagoPendienteComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PagoPendienteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
