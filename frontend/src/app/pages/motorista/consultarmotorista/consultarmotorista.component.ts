import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MotoristaService } from '../../../services/motorista.service';
import { RouterModule } from '@angular/router';
import { MotoristasLayoutComponent } from "../../../components/motoristas-layout/motoristas-layout.component";

interface Motorista {
  id: number; 
  nome: string;
  dataNascimento: string;
  cpf: string;
  modeloCarro: string;
  status: string;
  sexo: string;
}

@Component({
  selector: 'app-consultarmotorista',
  standalone: true,
  imports: [CommonModule, RouterModule, MotoristasLayoutComponent],
  templateUrl: './consultarmotorista.component.html',
  styleUrls: ['./consultarmotorista.component.scss']
})
export class ConsultarMotoristaComponent implements OnInit {
alterarStatus(arg0: number) {
throw new Error('Method not implemented.');
}
  motoristas: Motorista[] = [];
  loading = true;

  constructor(private motoristaService: MotoristaService) {}

  ngOnInit(): void {
    this.carregarMotoristas();
  }

  carregarMotoristas(): void {
    this.motoristaService.listarMotoristas().subscribe({
      next: (data) => {
        this.motoristas = data;
        this.loading = false;
      },
      error: (err: any) => {
        console.error('Erro ao carregar motoristas', err);
        this.loading = false;
      }
    });
  }
}