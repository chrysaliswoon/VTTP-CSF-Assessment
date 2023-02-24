import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { RestaurantService } from '../restaurant-service';

@Component({
  selector: 'app-restaurant-cuisine',
  templateUrl: './restaurant-cuisine.component.html',
  styleUrls: ['./restaurant-cuisine.component.css']
})
export class RestaurantCuisineComponent implements OnInit{
  restaurants: string[] = ['Ajisen Ramen', 'Chef Ho', 'China Grill', 'Citrus Bar & Grill', 'Indo'];

	// TODO Task 3
	// For View 2

  form!: FormGroup;

  constructor(private fb: FormBuilder, private restaurantSvc: RestaurantService){}


  ngOnInit(): void {
    this.form = this.createForm()
}


createForm(): FormGroup {
  return this.fb.group({
    cuisine: this.fb.control(''),
  })
}
	

  processForm() {
    const cuisine = this.form.value 

    this.restaurantSvc.getRestaurant(cuisine)
      .then(response => {
        this.form = this.createForm()

      })
      .catch(error => {
        console.error('>>> Error', error)
      })
  }

}
