import { Routes } from '@angular/router';
import { MotoristaComponent } from './pages/motorista/motorista.component';
import { CorridaComponent } from './pages/corrida/corrida.component';
import { PassageiroComponent } from './pages/passageiro/passageiro.component';
import { CadastroMotoristaComponent } from './pages/motorista/cadastromotorista/cadastromotorista.component';
import { AlterarStatusComponent } from './pages/motorista/alterar-status/alterar-status.component';
import { ConsultarMotoristaComponent } from './pages/motorista/consultarmotorista/consultarmotorista.component';

export const routes: Routes = [
    { path: "motorista", component:MotoristaComponent },
    { path: "corrida", component:CorridaComponent },
    { path: "passageiro", component:PassageiroComponent },
    { path: 'motorista/alterar-status', component: AlterarStatusComponent },
    { path: 'motorista/consultarmotorista', component: ConsultarMotoristaComponent },
    { path: 'motorista/cadastromotorista', component: CadastroMotoristaComponent },
];
