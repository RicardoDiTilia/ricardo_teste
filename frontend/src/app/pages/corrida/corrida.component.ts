import { Component } from '@angular/core';
import { CorridasLayoutComponent } from '../../components/corridas-layout/corridas-layout.component';
import {FormGroup,FormControl, ReactiveFormsModule, Validators} from '@angular/forms'

@Component({
  selector: 'app-corrida',
  standalone: true,
  imports: [
    CorridasLayoutComponent,
    ReactiveFormsModule
  ],
  templateUrl: './corrida.component.html',
  styleUrl: './corrida.component.scss'
})
export class CorridaComponent {
  CorridaForm!: FormGroup;

  constructor(){
    this.CorridaForm = new FormGroup({
      motorista: new FormControl('', [Validators.required]),
      passageiro: new FormControl('', [Validators.required]),
      valor: new FormControl('', [Validators.required]),
    })
  }
}
