import { Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { EmailComponent } from './components/email/email.component';

export const routes: Routes = [
    {
        path:"",
        component:HomeComponent,
        pathMatch:"full"
    },
    {
        path:"sendemail",
        component:EmailComponent,
        pathMatch:"full"
    }
];
