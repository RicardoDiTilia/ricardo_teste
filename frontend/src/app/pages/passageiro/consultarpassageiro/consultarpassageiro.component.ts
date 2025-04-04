import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PassageiroService } from '../../../services/passageiro.service';
import { RouterModule } from '@angular/router';
import { PassageirosLayoutComponent } from "../../../components/passageiros-layout/passageiros-layout.component";
import { FormsModule } from '@angular/forms';

interface Passageiro {
  id: number; 
  nome: string;
  dataNascimento: string;
  cpf: string;
  sexo: string;
}

@Component({
  selector: 'app-consultarpassageiro',
  standalone: true,
  imports: [CommonModule, RouterModule, FormsModule, PassageirosLayoutComponent],
  templateUrl: './consultarpassageiro.component.html',
  styleUrls: ['./consultarpassageiro.component.scss']
})
export class ConsultarPassageiroComponent implements OnInit {
  passageiros: Passageiro[] = [];
  loading = true;
  filtro: string = ''; 

  constructor(private passageiroService: PassageiroService) {}

  ngOnInit(): void {
    this.carregarPassageiros();
  }

  carregarPassageiros(): void {
    this.passageiroService.listarPassageiros().subscribe({
      next: (data) => {
        this.passageiros = data;
        this.loading = false;
      },
      error: (err: any) => {
        console.error('Erro ao carregar passageiros', err);
        this.loading = false;
      }
    });
  }

  passageirosFiltrados(): Passageiro[] {
    const termo = this.filtro.toLowerCase();
    return this.passageiros.filter((m) =>
      m.nome.toLowerCase().includes(termo) ||
      m.cpf.includes(termo) ||
      m.id.toString().includes(termo)
    );
  }
}
