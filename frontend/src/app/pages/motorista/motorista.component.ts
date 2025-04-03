import { Component } from '@angular/core';
import { MotoristasLayoutComponent } from '../../components/motoristas-layout/motoristas-layout.component';
import {FormGroup,FormControl, ReactiveFormsModule, Validators} from '@angular/forms'


@Component({
  selector: 'app-motorista',
  standalone: true,
  imports: [
    MotoristasLayoutComponent,
    ReactiveFormsModule
  ],
  templateUrl: './motorista.component.html',
  styleUrl: './motorista.component.scss'
})
export class MotoristaComponent {

}
