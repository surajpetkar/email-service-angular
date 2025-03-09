import { Component, inject } from '@angular/core';
import {MatButtonModule} from '@angular/material/button';
import {MatSnackBar} from '@angular/material/snack-bar';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';

@Component({
  selector: 'app-navbar',
  imports: [MatButtonModule,MatToolbarModule,MatIconModule],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {
    private _snackBar = inject(MatSnackBar);
    onClick(){
      console.log('BUTTON CLICKED');
      this._snackBar.open('WORKING..','Cancel');
    }
}
