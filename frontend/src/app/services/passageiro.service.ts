import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';

interface Passageiro {
  id: number; 
  nome: string;
  dataNascimento: string;
  cpf: string;
  sexo: string;
}

@Injectable({
  providedIn: 'root'
})
export class PassageiroService {
  private apiUrl = `${environment.apiUrl}/passageiros`;

  constructor(private http: HttpClient) { }

  getPassageiro(id: number): Observable<Passageiro> {
    return this.http.get<Passageiro>(`${this.apiUrl}/${id}`);
  }

  listarPassageiros(): Observable<Passageiro[]> {
    return this.http.get<Passageiro[]>(`${this.apiUrl}`);
  }
  cadastrarPassageiro(dadosBrutos: any): Observable<any> {
    return this.http.post(this.apiUrl, dadosBrutos);
  }
}