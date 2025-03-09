import { Component, inject } from '@angular/core';
import {MatButtonModule} from '@angular/material/button';
import {MatSnackBar} from '@angular/material/snack-bar';

@Component({
  selector: 'app-home',
  imports: [MatButtonModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  private _snackBar = inject(MatSnackBar);
  openEmailComponent(){
    console.log('BUTTON CLICKED');
    this._snackBar.open('WORKING..','Cancel');
  }
}
