import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TitleDetailComponent } from './title-detail.component';

describe('TitleDetailComponent', () => {
  let component: TitleDetailComponent;
  let fixture: ComponentFixture<TitleDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TitleDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TitleDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
