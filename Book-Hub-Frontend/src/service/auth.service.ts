import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
// import { environment } from 'src/environments/environment.development';
import { environment } from 'src/environments/environment';


import { SignIn, SignUp } from 'src/interface/user';

@Injectable({
  providedIn: 'root',
})
export class AuthService {


   baseUrl:string = environment.apiUrl;

  constructor(private http: HttpClient) {}

  registerUser(data: SignUp): Observable<SignUp> {
    return this.http.post<SignUp>(`${this.baseUrl}/auth/signup/user`, data);
  }


  loginUser(data: SignIn): Observable<any> {
    const credentials = btoa(data.email + ':' + data.password);
  
    const requestHeaders = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Basic ' + credentials,
    });
  
    const options = { headers: requestHeaders, observe: 'response' as const };
  
    return this.http.get<any>(`${this.baseUrl}/auth/signin`, options);
  }

  checkUserLogin(){

  }
}
