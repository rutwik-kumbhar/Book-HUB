import { Component } from '@angular/core';
import { parse } from '@fortawesome/fontawesome-svg-core';
import { LocalstorageService } from 'src/service/localstorage.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent {
  constructor(private localstorage: LocalstorageService) {
    console.log(this.userRole());
  }

  isUserLogin() {
    return this.localstorage.isUserLogin();
  }

  userLogout() {
    this.localstorage.clearLocalStorage();
  }

  userRole() {
    const role = this.localstorage.getRole();

    if(role != null){
      return role;
    }else{
      return "";
    }
  }
}
