import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import {AlertService} from './alert.service';

@Injectable()
export class AuthenticationService {
  constructor(private http: Http, private alertService: AlertService) { }

  login(username: string, password: string) {
    return this.http.post(`http://localhost:8080/Movieflix/api/Users/userName/${username}`, password)
      .map((response: Response) => {
      console.log('in authentication service')
        // login successful if there's a jwt token in the response
        let user = response.json();
        if (user.username === 'admin') {
          // store user details and jwt token in local storage to keep user logged in between page refreshes
          localStorage.setItem('adminUser', JSON.stringify(user));
          localStorage.setItem('currentUser', JSON.stringify(user));

        } else if (user) {
          // store user details and jwt token in local storage to keep user logged in between page refreshes
          localStorage.setItem('currentUser', JSON.stringify(user));
        } else {
          this.alertService.error('Login Unsuccessful.');
        }
      });
  }

  logout() {
    // remove user from local storage to log user out
    localStorage.removeItem('currentUser');
    localStorage.removeItem('adminUser');

  }
}
