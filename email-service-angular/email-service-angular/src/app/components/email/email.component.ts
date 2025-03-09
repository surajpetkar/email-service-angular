import { Component, inject } from '@angular/core';
import { FormControl, Validators, FormsModule, ReactiveFormsModule } from '@angular/forms';
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
import { MatSnackBar } from '@angular/material/snack-bar';
import { EmailService } from '../../service/email.service';
import { response } from 'express';
import { error } from 'console';

@Component({
  selector: 'app-email',
  imports: [FormsModule, MatInputModule, ReactiveFormsModule, MatButtonModule],
  templateUrl: './email.component.html',
  styleUrl: './email.component.css'
})
export class EmailComponent {
  emailFormControl = new FormControl('', [Validators.required, Validators.email]);
  subjectFormControl = new FormControl('', [Validators.required, Validators.minLength(1)]);
  bodyFormControl = new FormControl('', [Validators.required, Validators.minLength(1)]);

  data = {
    to : "",
    subject : "",
    message : ""
  }

  private _snackBar = inject(MatSnackBar);
  private _sendMail = inject(EmailService);

    sendMail(){
      console.log(this.data);
      this._sendMail.sendMail(this.data).subscribe(
        response => {
          console.log(response);
          this._snackBar.open(response.toString(),'Cancel');
        },
        error => {
          console.log(error);
          this._snackBar.open(error.text,'Cancel');
        }
      )
    }
}
