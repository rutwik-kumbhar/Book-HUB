import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  baseUrl = environment.apiUrl;

  constructor(private http: HttpClient) { }


  addBook(book:any):Observable<any>{
    return this.http.post<any>(`${this.baseUrl}/books/add` , book);
  }
}
