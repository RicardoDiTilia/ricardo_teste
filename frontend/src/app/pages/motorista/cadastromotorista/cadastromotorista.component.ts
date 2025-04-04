import { Component } from '@angular/core';
import { MotoristasLayoutComponent } from '../../../components/motoristas-layout/motoristas-layout.component';
import {FormGroup,FormControl, ReactiveFormsModule, Validators} from '@angular/forms'
import { MotoristaService } from '../../../services/motorista.service';
import { Router } from '@angular/router';

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
  motoristaForm = new FormGroup({
nome: new FormControl('', [Validators.required]),
      dataNascimento: new FormControl('', [Validators.required]),
      cpf: new FormControl('', [Validators.required]),
      modeloCarro: new FormControl('', [Validators.required]),
      status: new FormControl('', [Validators.required]),
      sexo: new FormControl('', [Validators.required]),
  });

  constructor(
    private motoristaService: MotoristaService,
    private router: Router
  ) {}

  onSubmit() {
    this.motoristaService.cadastrarMotorista(this.motoristaForm.value)
      .subscribe({
        next: () => this.router.navigate(['/motorista']),
        error: (err: any) => console.error('Erro:', err)
      });
  }
}


