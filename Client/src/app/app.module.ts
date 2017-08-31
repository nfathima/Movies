import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import {BaseRequestOptions, HttpModule} from '@angular/http';
import { RouterModule, Routes } from '@angular/router';
import { AddUserComponent } from './add-user/add-user.component';
import {UserService} from './user-service/user.service';
import { TitleComponent } from './Title/title.component';
import {TitleService} from './Title-service/title.service';
import { EditTitleComponent } from './add-Title/edit-title.component';
import { TitleDetailComponent } from './title-detail/title-detail.component';
import {AlertComponent} from './_directives/alert.component';
import {AuthGuard} from './_guards/auth.guard';
import {AlertService} from './_services/alert.service';
import {AuthenticationService} from './_services/authentication.service';
import {customHttpProvider} from './_helpers/custom-http';
import {InlineEditorModule} from '@qontu/ngx-inline-editor';
import {AdminGuard} from './_guards/admin.guard';


const appRoutes: Routes = [
  {path: 'login', component: AddUserComponent},
  {path: 'modify-Title', component: EditTitleComponent, canActivate: [AdminGuard] },
  {path: 'Title/:id', component: TitleDetailComponent, canActivate: [AuthGuard]},
  {path: 'Title', component: TitleComponent, canActivate: [AuthGuard] },
  {path: '', redirectTo: '/login', pathMatch: 'full'}];
  // otherwise redirect to home


@NgModule({
  declarations: [
    AppComponent,
    AddUserComponent,
    TitleComponent,
    EditTitleComponent,
    TitleDetailComponent,
    AlertComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    InlineEditorModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [UserService, TitleService, AuthGuard, AdminGuard,
    customHttpProvider,
    AlertService,
    AuthenticationService, BaseRequestOptions],
  bootstrap: [AppComponent]
})
export class AppModule {
}
