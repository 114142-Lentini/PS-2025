import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AltaGeneradorComponent } from './alta-generador.component';

describe('AltaGeneradorComponent', () => {
  let component: AltaGeneradorComponent;
  let fixture: ComponentFixture<AltaGeneradorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AltaGeneradorComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AltaGeneradorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
