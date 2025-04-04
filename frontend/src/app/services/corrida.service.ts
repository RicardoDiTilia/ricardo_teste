import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

export interface Corrida {
  id: number;
  valor: number;
  status: string;
  dataHora: string; 
  motorista: {
    id: number;
    nome: string;
  };
  passageiro: {
    id: number;
    nome: string;
  };
}


@Injectable({
  providedIn: 'root'
})
export class CorridaService {
  private apiUrl = `${environment.apiUrl}/corridas`;

  constructor(private http: HttpClient) {}

  listarCorridas(): Observable<Corrida[]> {
    return this.http.get<Corrida[]>(this.apiUrl);
  }

  buscarCorridaPorId(id: number): Observable<Corrida> {
    return this.http.get<Corrida>(`${this.apiUrl}/${id}`);
  }

  registrarCorrida(dados: any): Observable<Corrida> {
    return this.http.post<Corrida>(this.apiUrl, dados);
  }

  alterarStatus(id: number, status: string): Observable<Corrida> {
    return this.http.patch<Corrida>(`${this.apiUrl}/${id}/status?status=${status}`, {});
  }
}
