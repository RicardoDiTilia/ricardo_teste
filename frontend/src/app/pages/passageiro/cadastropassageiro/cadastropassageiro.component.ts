import { Component } from '@angular/core';
import {FormBuilder, FormGroup,FormControl, ReactiveFormsModule, Validators} from '@angular/forms'
import { PassageiroService } from '../../../services/passageiro.service';
import { Router } from '@angular/router';
import { PassageirosLayoutComponent } from '../../../components/passageiros-layout/passageiros-layout.component';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-cadastropassageiro',
  standalone: true,
  imports: [
    PassageirosLayoutComponent,
    CommonModule,
    ReactiveFormsModule
  ],
  templateUrl: './cadastropassageiro.component.html',
  styleUrls: ['./cadastropassageiro.component.scss']
})
export class CadastroPassageiroComponent {
  passageiroForm = new FormGroup({
nome: new FormControl('', [Validators.required]),
      dataNascimento: new FormControl('', [Validators.required]),
      cpf: new FormControl('', [Validators.required]),
      sexo: new FormControl('', [Validators.required]),
  });

  constructor(
    private passageiroService: PassageiroService,
    private router: Router
  ) {}

  onSubmit() {
    this.passageiroService.cadastrarPassageiro(this.passageiroForm.value)
      .subscribe({
        next: () => this.router.navigate(['/passageiro']),
        error: (err: any) => console.error('Erro:', err)
      });
  }
}


