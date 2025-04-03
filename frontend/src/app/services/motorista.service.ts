import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';

interface Motorista {
  id: number; 
  nome: string;
  dataNascimento: string;
  cpf: string;
  modeloCarro: string;
  status: string;
  sexo: string;
}

@Injectable({
  providedIn: 'root'
})
export class MotoristaService {
  private apiUrl = `${environment.apiUrl}/motoristas`;

  constructor(private http: HttpClient) { }

  getMotorista(id: number): Observable<Motorista> {
    return this.http.get<Motorista>(`${this.apiUrl}/${id}`);
  }

  alterarStatus(id: number, status: string): Observable<any> {
    return this.http.patch(`${this.apiUrl}/${id}`, { status });
  }
  listarMotoristas(): Observable<Motorista[]> {
    return this.http.get<Motorista[]>(`${this.apiUrl}`);
  }
  cadastrarMotorista(dadosBrutos: any): Observable<any> {
    return this.http.post(this.apiUrl, dadosBrutos);
  }
}