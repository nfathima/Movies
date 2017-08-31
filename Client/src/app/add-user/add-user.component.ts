import { Component, OnInit } from '@angular/core';
import {UserService} from '../user-service/user.service';
import {ActivatedRoute, Router} from '@angular/router';
import { AlertService, AuthenticationService } from '../_services/index';

@Component({
  moduleId: module.id,
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {

  check= false;
  loading = false;
  returnUrl: string;
  errorval;
  user = {
    userName: null,
    privilege: 'user',
    password: null,
    repeatPassword: null
  };
  login = {
    userName: null,
    password: null,
  };

  ngOnInit() {
    // reset login status
    this.authenticationService.logout();

    // get return url from route parameters or default to '/'
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
  }

  constructor(private userService: UserService,
              private route: ActivatedRoute,
              private router: Router,
              private authenticationService: AuthenticationService,
              private alertService: AlertService) { }

    addUser() {
      this.loading = true;
      this.userService.addUser(this.user)
        .subscribe(user => {
          this.errorval = 'addsuccess';
          this.alertService.success('Registration successful.Login to continue', true);
          this.router.navigate(['/login']);
        },
          error => {
            this.errorval = 'adderror';
            this.alertService.error(error);
            this.loading = false;
          });
    }
  getUser() {
    this.loading = true;
    this.authenticationService.login(this.login.userName, this.login.password)
      .subscribe(login => {
        this.router.navigate(['/Title']);
        },
        error => { this.errorval = 'geterror';
           this.alertService.error(error);
    this.loading = false; });

  }



}
