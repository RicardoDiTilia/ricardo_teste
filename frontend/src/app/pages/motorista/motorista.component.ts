import { Component } from '@angular/core';
import { MotoristasLayoutComponent } from '../../components/motoristas-layout/motoristas-layout.component';
import {FormGroup,FormControl, ReactiveFormsModule, Validators} from '@angular/forms'

@Component({
  selector: 'app-motorista',
  standalone: true,
  imports: [
    MotoristasLayoutComponent,
    ReactiveFormsModule
  ],
  templateUrl: './motorista.component.html',
  styleUrl: './motorista.component.scss'
})
export class MotoristaComponent {
/*  MotoristaForm!: FormGroup;

  constructor(){
    this.MotoristaForm = new FormGroup({
      nome: new FormControl('', [Validators.required, Validators.pattern(/^\d{3}\.\d{3}\.\d{3}-\d{2}$/)]),
      dataNascimento: new FormControl('', [Validators.required]),
      cpf: new FormControl('', [Validators.required]),
      modeloCarro: new FormControl('', [Validators.required]),
      status: new FormControl('', [Validators.required]),
      sexo: new FormControl('', [Validators.required]),
    })
  }*/
}
