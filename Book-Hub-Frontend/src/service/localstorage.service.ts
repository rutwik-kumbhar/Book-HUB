import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LocalstorageService {

  constructor() { }


  public setToken(token:string):void{
      localStorage.setItem('token',token );
  }

  public setRole(role:string){
    localStorage.setItem('role', role);
  }
  public getRole(){
    return localStorage.getItem('role');
  }


  public getToken():any{
    return localStorage.getItem('token');
  }

  public isUserLogin(){
    return this.getToken();
  }

  public clearLocalStorage(){
    localStorage.clear();
  }




}
