import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { BookformComponent } from './bookform/bookform.component';
import { HttpClientModule } from "@angular/common/http";
import { RouterModule, Routes } from '@angular/router';
import { SearchbookComponent } from './searchbook/searchbook.component';

const routes: Routes = [
  {path:'bookform', component : BookformComponent},
  { path: 'searchbook', component: SearchbookComponent },
  
]
@NgModule({
  declarations: [
    AppComponent,
    BookformComponent,
    SearchbookComponent
  ],
  imports: [
    BrowserModule, 
    FormsModule,
    HttpClientModule, RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
