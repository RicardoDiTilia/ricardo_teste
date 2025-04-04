import { Routes } from '@angular/router';
import { MotoristaComponent } from './pages/motorista/motorista.component';
import { CorridaComponent } from './pages/corrida/corrida.component';
import { PassageiroComponent } from './pages/passageiro/passageiro.component';
import { CadastroMotoristaComponent } from './pages/motorista/cadastromotorista/cadastromotorista.component';
import { AlterarStatusComponent } from './pages/motorista/alterar-status/alterar-status.component';
import { ConsultarMotoristaComponent } from './pages/motorista/consultarmotorista/consultarmotorista.component';
import { CadastroPassageiroComponent } from './pages/passageiro/cadastropassageiro/cadastropassageiro.component';
import { ConsultarPassageiroComponent } from './pages/passageiro/consultarpassageiro/consultarpassageiro.component';
import { ConsultarCorridaComponent } from './pages/corrida/consultarcorrida/consultarcorrida.component';
import { RegistrarCorridaComponent } from './pages/corrida/registrarcorrida/registrarcorrida.component';

export const routes: Routes = [
  { path: '', redirectTo: 'motorista', pathMatch: 'full' },
  { path: 'motorista', component: MotoristaComponent },
  { path: 'passageiro', component: PassageiroComponent },
  { path: 'corrida', component: CorridaComponent },
  { path: 'motorista/cadastromotorista', component: CadastroMotoristaComponent },
  { path: 'motorista/consultarmotorista', component: ConsultarMotoristaComponent },
  { path: 'motorista/alterar-status', component: AlterarStatusComponent },
  { path: 'passageiro/cadastropassageiro', component: CadastroPassageiroComponent },
  { path: 'passageiro/consultarpassageiro', component: ConsultarPassageiroComponent },
  { path: 'corrida/consultarcorrida', component: ConsultarCorridaComponent },
  { path: 'corrida/registrarcorrida', component: RegistrarCorridaComponent },
];
