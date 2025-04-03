import { Routes } from '@angular/router';
import { MotoristaComponent } from './pages/motorista/motorista.component';
import { CorridaComponent } from './pages/corrida/corrida.component';
import { PassageiroComponent } from './pages/passageiro/passageiro.component';
import { CadastroMotoristaComponent } from './pages/motorista/cadastromotorista/cadastromotorista.component';

export const routes: Routes = [
    { path: "motorista", component:MotoristaComponent },
    { path: "corrida", component:CorridaComponent },
    { path: "passageiro", component:PassageiroComponent },
 //   { path: 'alterar-status', component: AlterarStatusComponent },
 //   { path: 'consultarmotorista', component: ConsultaMotoristaComponent },
    { path: 'cadastromotorista', component: CadastroMotoristaComponent },
];
