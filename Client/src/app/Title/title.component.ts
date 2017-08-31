import { Component, OnInit } from '@angular/core';
import {TitleService} from '../Title-service/title.service';
import {Router} from '@angular/router';
import {Http} from '@angular/http';


@Component({
  selector: 'app-title',
  templateUrl: './title.component.html',
  styleUrls: ['./title.component.css']
})
export class TitleComponent {
  access= false;
  title= {
    titleId: null,
    name: null,
  imdbRatings: null,
  type: null,
  year: null,
  genre: null,
  imdbVotes: null,
  director: null,
  actors: null,
  plot: null

}
  titles;
  freesearch;
  topTVRes;
  topMoviesRes;
  freeSearchRes = {
    titleId: null,
    name: null,
    imdbRatings: null,
    type: null,
    year: null,
    genre: null,
    imdbVotes: null,
    director: null,
    actors: null,
    plot: null
  }
  votesRes;
  ratingsRes;
  yearRes;
  fyearRes;
  ftypeRes;
  fgenreRes;
  filter;
display = 'home';
  home() {
    this.display = 'home';
  }
  moredet() {
    this.display = 'moredet';
  }


constructor(private titleService: TitleService, private router: Router, private http: Http) {
    titleService.getAllTitle()
      .subscribe(
        titles => {this.titles = titles; console.log(titles); },
        error => console.log(error)

      );
  if (localStorage.getItem('adminUser')) {
    this.access = true;
  }
  }

  sortfunction(var1) {
    if (var1 === 'ratings') {
      this.imdbRatings(); } else if (var1 === 'votes') {
      this.imdbVotes(); } else { this.year(); }

   }
  filterfunction(var1, var2) {
    this.filter = var1;
    if (var2 === 'type' ) {this.ftype(); } else if (var2 === 'genre') {this.fgenre(); } else {this.fyear(); }
  }
  freesearch1() {
    this.display = 'freesearch';
    if (this.freesearch === '' || this.freesearch == null) {
      this.display = 'home';
    } else {
    this.titleService.freesearch1(this.freesearch)
      .subscribe(freeSearchRes => {
        this.freeSearchRes = freeSearchRes; console.log(freeSearchRes);
      });
    }
  }

  imdbVotes() {
    this.display = 'votes';
          this.titleService.imdbVotes()
        .subscribe(votesRes => {
          this.votesRes = votesRes; console.log(votesRes);
        });
    }

    imdbRatings() {
      this.display = 'ratings';
        this.titleService.imdbRatings()
          .subscribe(ratingsRes => {
            this.ratingsRes = ratingsRes; console.log(ratingsRes);
          });
      }
  year() {
    this.display = 'year';
    this.titleService.year()
      .subscribe(yearRes => {
        this.yearRes = yearRes; console.log(yearRes);
      });
  }

  fyear() {
    this.display = 'fyear';
    this.titleService.fyear(this.filter)
      .subscribe(fyearRes => {
        this.fyearRes = fyearRes; console.log(fyearRes);
      });
  }

  ftype() {
    this.display = 'ftype';
    this.titleService.ftype(this.filter)
      .subscribe(ftypeRes => {
        this.ftypeRes = ftypeRes; console.log(ftypeRes);
      });
  }

  fgenre() {
    this.display = 'fgenre';
    this.titleService.fgenre(this.filter)
      .subscribe(fgenreRes => {
        this.fgenreRes = fgenreRes; console.log(fgenreRes);
      });
  }

  topMovies() {
    this.display = 'topm';
    this.titleService.topMovies()
      .subscribe(topMoviesRes => {
        this.topMoviesRes = topMoviesRes; console.log(topMoviesRes);
      });
  }
  topTV() {
    this.display = 'topt';
    this.titleService.topTV()
      .subscribe(topTVRes => {
        this.topTVRes = topTVRes; console.log(topTVRes);
      });
  }

  modifyAccess() {
    if (localStorage.getItem('adminUser')) {
      this.access = true;
    }

  }
  }
