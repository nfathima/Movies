import { Injectable } from '@angular/core';
import {Http, RequestOptions, Headers, Response} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import 'rxjs/add/observable/throw';

@Injectable()
export class UserService {

  constructor(private http: Http) { }

  addUser(user): Observable<any> {
    // let headers = new Headers({'Authorization': 'asdfasdfasdfasd'});
    // let options = new RequestOptions({headers: headers});

    return this.http.post('http://localhost:8080/Movieflix/api/Users', user, this.jwt())
      .map(response => response.json())
      .catch(error => Observable.throw(error.statusText));
  }
  getUser(userName, password): Observable<any> {
    // let headers = new Headers({'Authorization': 'asdfasdfasdfasd'});
    // let options = new RequestOptions({headers: headers});

    return this.http.post(`http://localhost:8080/Movieflix/api/Users/userName/${userName}`, password, this.jwt())
      .map(response => response.json())
      .catch((error) => Observable.throw(error.statusText));
  }

  private jwt() {
    // create authorization header with jwt token
    let currentUser = JSON.parse(localStorage.getItem('currentUser'));
    if (currentUser && currentUser.token) {
      let headers = new Headers({ 'Authorization': 'Bearer ' + currentUser.token });
      return new RequestOptions({headers: headers});
    }
  }
}
