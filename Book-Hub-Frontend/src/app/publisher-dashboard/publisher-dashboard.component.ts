import { Component } from '@angular/core';

@Component({
  selector: 'app-publisher-dashboard',
  templateUrl: './publisher-dashboard.component.html',
  styleUrls: ['./publisher-dashboard.component.css']
})
export class PublisherDashboardComponent {

  addBook(){
    alert("Add Book");
  }

}
