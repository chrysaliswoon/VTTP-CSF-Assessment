import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';


import { AppComponent } from './app.component';
import { CuisineListComponent } from './components/cuisine-list.component';
import { RestaurantCuisineComponent } from './components/restaurant-cuisine.component';
import { RestaurantDetailsComponent } from './components/restaurant-details.component';
import { MaterialModule } from './material.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RestaurantService } from './restaurant-service';
import { Router, RouterModule, Routes } from '@angular/router';

const appsRoute: Routes = [
  { path: '', component: CuisineListComponent },
  { path: 'restaurants', component: RestaurantCuisineComponent },
  { path: 'restaurant', component: RestaurantDetailsComponent },
  { path: '**', redirectTo: '/', pathMatch: 'full'}
]

@NgModule({
  declarations: [
    AppComponent,
    CuisineListComponent,
    RestaurantCuisineComponent,
    RestaurantDetailsComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpClientModule,
    MaterialModule,
    BrowserAnimationsModule,
    RouterModule.forRoot(appsRoute)
    
  ],
  providers: [RestaurantService],
  bootstrap: [AppComponent]
})
export class AppModule { }
