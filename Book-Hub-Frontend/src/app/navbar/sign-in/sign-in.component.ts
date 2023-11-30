import { HttpClient ,HttpHeaders} from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { SignIn } from 'src/interface/user';
import { AuthService } from 'src/service/auth.service';
import { LocalstorageService } from 'src/service/localstorage.service';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent {

  
  

  constructor(private authService :AuthService , private router: Router,private localstorage: LocalstorageService ){

  }

  signIN(data:SignIn){
    this.authService.loginUser(data).subscribe((res)=>{
        // console.log(res.headers.get('Authorization'))
        this.localstorage.setToken(res.headers.get('Authorization'))
        // console.log(res.body)
        this.localstorage.setRole(res.body.role);
    },(error)=>{
        alert("Login Failed")
    },()=>{
      alert("Login Successfull");
      this.router.navigate(['/'])
    })
      
  }




}
