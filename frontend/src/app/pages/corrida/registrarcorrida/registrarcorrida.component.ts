import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { CorridaService } from '../../../services/corrida.service';
import { MotoristaService } from '../../../services/motorista.service';
import { PassageiroService } from '../../../services/passageiro.service';
import { CorridasLayoutComponent } from "../../../components/corridas-layout/corridas-layout.component";

@Component({
  selector: 'app-registrarcorrida',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, CorridasLayoutComponent],
  templateUrl: './registrarcorrida.component.html',
  styleUrls: ['./registrarcorrida.component.scss']
})
export class RegistrarCorridaComponent implements OnInit {
  form!: FormGroup;
  motoristas: any[] = [];
  passageiros: any[] = [];

  constructor(
    private fb: FormBuilder,
    private corridaService: CorridaService,
    private motoristaService: MotoristaService,
    private passageiroService: PassageiroService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.form = this.fb.group({
      motoristaId: ['', Validators.required],
      passageiroId: ['', Validators.required],
      status: ['SOLICITADA', Validators.required],
      valor: [0, [Validators.required, Validators.min(0.01)]]
    });

    this.motoristaService.listarMotoristas().subscribe(data => this.motoristas = data);
    this.passageiroService.listarPassageiros().subscribe(data => this.passageiros = data);
  }

  registrar(): void {

    const dados = {
      motorista: { id: Number(this.form.value.motoristaId) },
      passageiro: { id: Number(this.form.value.passageiroId) },
      valor: this.form.value.valor,
      status: this.form.value.status
    };
    console.log('Enviando dados:', dados);

    this.corridaService.registrarCorrida(dados).subscribe({
      next: () => {
        alert('Corrida registrada com sucesso!');
        this.router.navigate(['/corrida']);
      },
      error: (err) => console.error('Erro ao registrar corrida:', err)
    });
  }
}
