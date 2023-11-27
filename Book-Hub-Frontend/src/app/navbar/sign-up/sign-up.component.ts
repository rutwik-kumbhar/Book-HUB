import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { SignUp } from 'src/interface/user';
import { AuthService } from 'src/service/auth.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent {

constructor(private authService:AuthService ,private router:Router ){}

  signUpUser(data:SignUp){
    this.authService.registerUser(data).subscribe((res)=>{
        console.log(res)
    },(error)=>{
        alert("Unable to Sign up")
    },()=>{
      alert("sucess");
      this.router.navigate(['/sign-in'])
    })
  }

}
