import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MotoristaService } from '../../../services/motorista.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MotoristasLayoutComponent } from '../../../components/motoristas-layout/motoristas-layout.component'; // ajuste o caminho conforme a estrutura


@Component({
  standalone: true,
  selector: 'app-alterar-status',
  templateUrl: './alterar-status.component.html',
  imports: [CommonModule, FormsModule, MotoristasLayoutComponent]
})

export class AlterarStatusComponent implements OnInit {
  motoristaId!: number;
  statusAtual: string = '';
  novoStatus: string = 'ATIVO';

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private motoristaService: MotoristaService
  ) {}

  ngOnInit(): void {
    this.motoristaId = Number(this.route.snapshot.paramMap.get('id'));

    this.motoristaService.getMotorista(this.motoristaId).subscribe(data => {
      this.statusAtual = data.status;
      this.novoStatus = data.status; 
    });
  }

  salvarStatus() {
    this.motoristaService.alterarStatus(this.motoristaId, this.novoStatus).subscribe(() => {
      alert('Status alterado com sucesso!');
      this.router.navigate(['/consultar']);
    }, err => {
      alert('Erro ao alterar status: ' + err.error.message);
    });
  }

  cancelar() {
    this.router.navigate(['/consultar']);
  }
}