import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { CorridaService } from '../../../services/corrida.service';
import { CorridasLayoutComponent } from "../../../components/corridas-layout/corridas-layout.component"; 
import { FormsModule } from '@angular/forms';
import { Corrida } from '../../../services/corrida.service';


@Component({
  selector: 'app-consultarcorrida',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule, CorridasLayoutComponent],
  templateUrl: './consultarcorrida.component.html',
  styleUrls: ['./consultarcorrida.component.scss']
})
export class ConsultarCorridaComponent implements OnInit {
  corridas: Corrida[] = [];
  loading = true;
  filtro: string ='';
  constructor(private corridaService: CorridaService) {}

  ngOnInit(): void {
    this.carregarCorridas();
  }
  corridasFiltradas(): Corrida[] {
    const termo = this.filtro.toLowerCase();
    return this.corridas.filter((c) =>
      c.id.toString().includes(termo) ||
      c.status.toLowerCase().includes(termo) ||
      c.motorista.nome.toLowerCase().includes(termo) ||
      c.passageiro.nome.toLowerCase().includes(termo)
    );
  }

  carregarCorridas(): void {
    this.corridaService.listarCorridas().subscribe({
      next: (data) => {
        this.corridas = data;
        this.loading = false;
      },
      error: (err) => {
        console.error('Erro ao carregar corridas:', err);
        this.loading = false;
      }
    });
  }
}
