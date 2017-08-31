import { Injectable } from '@angular/core';
import { Http,  Headers, RequestOptions, Response } from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import 'rxjs/add/observable/throw';
@Injectable()
export class TitleService {

  constructor(private http: Http) { }
  addTitle(title): Observable<any> {
    return this.http.post('http://localhost:8080/Movieflix/api/Title', title,this.jwt())
      .map(response => response.json())
      .catch(error => Observable.throw(error.statusText));
  }
  deleteTitle(id): Observable<any> {
    return this.http.delete(`http://localhost:8080/Movieflix/api/Title/${id}`,this.jwt())
      .map(response => response.json())
      .catch(error => Observable.throw(error.statusText));
  }
  updateTitle(title): Observable<any> {
    return this.http.put(`http://localhost:8080/Movieflix/api/Title/${title.titleId}`, title,this.jwt())
      .map(response => response.json())
      .catch(error => Observable.throw(error.statusText));
  }
  displayTitle(title): Observable<any> {
    return this.http.get('http://localhost:8080/Movieflix/api/',this.jwt())
      .map(response => response.json())
      .catch(error => Observable.throw(error.statusText));
  }

  getOneTitle(id): Observable<any> {
    return this.http.get(`http://localhost:8080/Movieflix/api/Title/${id}`,this.jwt())
      .map(response => response.json())
      .catch(error => Observable.throw(error.statusText));
  }
  getAllTitle(): Observable<any> {
    return this.http.get('http://localhost:8080/Movieflix/api/Title/All',this.jwt())
      .map(response => response.json())
      .catch(error => Observable.throw(error.statusText));
  }
  displayavgRat(id): Observable<any> {
    return this.http.get(`http://localhost:8080/Movieflix/api/${id}/AvgRatings`,this.jwt())
      .map(response => response.json())
      .catch(error => Observable.throw(error.statusText));
  }

  displayComments(id): Observable<any> {
    return this.http.get(`http://localhost:8080/Movieflix/api/${id}/Comments`,this.jwt())
      .map(response => response.json())
      .catch(error => Observable.throw(error.statusText));
  }
  addRatcom(id, comments): Observable<any> {
    return this.http.post(`http://localhost:8080/Movieflix/api/${id}/PostRatingsAndComments`, comments,this.jwt())
      .map(response => response.json())
      .catch(error => Observable.throw(error.statusText));
  }
  freesearch1(freesearch): Observable<any> {
    return this.http.get(`http://localhost:8080/Movieflix/api/TitleSearch/${freesearch}`,this.jwt())
      .map(response => response.json())
      .catch(error => Observable.throw(error.statusText));
  }
  imdbRatings(): Observable<any> {
    return this.http.get('http://localhost:8080/Movieflix/api/Title/SortByRatings',this.jwt())
      .map(response => response.json())
      .catch(error => Observable.throw(error.statusText));
  }
  imdbVotes(): Observable<any> {
    return this.http.get('http://localhost:8080/Movieflix/api/Title/SortByVotes',this.jwt())
      .map(response => response.json())
      .catch(error => Observable.throw(error.statusText));
  }
  year(): Observable<any> {
    return this.http.get('http://localhost:8080/Movieflix/api/Title/SortByYear',this.jwt())
      .map(response => response.json())
      .catch(error => Observable.throw(error.statusText));
  }

  fyear(id): Observable<any> {
    return this.http.get(`http://localhost:8080/Movieflix/api/Title/Year/${id}`,this.jwt())
      .map(response => response.json())
      .catch(error => Observable.throw(error.statusText));
  }
  ftype(id): Observable<any> {
    return this.http.get(`http://localhost:8080/Movieflix/api/Title/Type/${id}`,this.jwt())
      .map(response => response.json())
      .catch(error => Observable.throw(error.statusText));
  }
  fgenre(id): Observable<any> {
    return this.http.get(`http://localhost:8080/Movieflix/api/Title/Genre/${id}`,this.jwt())
      .map(response => response.json())
      .catch(error => Observable.throw(error.statusText));
  }

  topMovies(): Observable<any> {
    return this.http.get('http://localhost:8080/Movieflix/api/TopMovies',this.jwt())
      .map(response => response.json())
      .catch(error => Observable.throw(error.statusText));
  }

  topTV(): Observable<any> {
    return this.http.get('http://localhost:8080/Movieflix/api/TopTVSeries',this.jwt())
      .map(response => response.json())
      .catch(error => Observable.throw(error.statusText));
  }

  private jwt() {
    // create authorization header with jwt token
    let currentUser = JSON.parse(localStorage.getItem('currentUser'));
    if (currentUser && currentUser.token) {
      let headers = new Headers({ 'Authorization': 'Bearer ' + currentUser.token });
      return new RequestOptions({ headers: headers });
    }
  }
}
