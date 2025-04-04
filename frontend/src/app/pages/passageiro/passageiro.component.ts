import { Component } from '@angular/core';
import { PassageirosLayoutComponent } from '../../components/passageiros-layout/passageiros-layout.component';
import {FormGroup,FormControl, ReactiveFormsModule, Validators} from '@angular/forms'


@Component({
  selector: 'app-passageiro',
  standalone: true,
  imports: [
        PassageirosLayoutComponent,
        ReactiveFormsModule
  ],
  templateUrl: './passageiro.component.html',
  styleUrl: './passageiro.component.scss'
})
export class PassageiroComponent {
  PassageiroForm!: FormGroup;


}


