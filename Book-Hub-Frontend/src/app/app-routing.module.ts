import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignInComponent } from './navbar/sign-in/sign-in.component';
import { HomeComponent } from './home/home.component';
import { SignUpComponent } from './navbar/sign-up/sign-up.component';
import { PublisherDashboardComponent } from './publisher-dashboard/publisher-dashboard.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';

const routes: Routes = [
  {path:'' , component:HomeComponent},
  {path: 'sign-in' , component:SignInComponent},
  {path:'sign-up',component:SignUpComponent},
  {path:'publisher', component:PublisherDashboardComponent},
  {path:'admin', component:AdminDashboardComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
