import { Component } from '@angular/core';
import { MotoristasLayoutComponent } from '../../../components/motoristas-layout/motoristas-layout.component';
import {FormGroup,FormControl, ReactiveFormsModule, Validators} from '@angular/forms'

@Component({
  selector: 'app-cadastromotorista',
  standalone: true,
  imports: [
    MotoristasLayoutComponent,
    ReactiveFormsModule
  ],
  templateUrl: './cadastromotorista.component.html',
  styleUrl: './cadastromotorista.component.scss'
})
export class CadastroMotoristaComponent { 
  MotoristaForm!: FormGroup;

  constructor(){
    this.MotoristaForm = new FormGroup({
      nome: new FormControl('', [Validators.required, Validators.pattern(/^\d{3}\.\d{3}\.\d{3}-\d{2}$/)]),
      dataNascimento: new FormControl('', [Validators.required]),
      cpf: new FormControl('', [Validators.required]),
      modeloCarro: new FormControl('', [Validators.required]),
      status: new FormControl('', [Validators.required]),
      sexo: new FormControl('', [Validators.required]),
    })
  }

}


