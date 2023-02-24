import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Restaurant } from '../models';
import { RestaurantService } from '../restaurant-service';

@Component({
  selector: 'app-cuisine-list',
  templateUrl: './cuisine-list.component.html',
  styleUrls: ['./cuisine-list.component.css']
})
export class CuisineListComponent implements OnInit{

	// TODO Task 2
	// For View 1
  cuisines: string[] = ['Afghan', 'African', 'American', 'Armenian', 'Asian'];
  form!: FormGroup
  selectedCuisine: String = '';

  constructor(private fb: FormBuilder, private restaurantSvc: RestaurantService){}

  ngOnInit(): void {
      this.form = this.createForm()
  }



	createForm(): FormGroup {
		return this.fb.group({
			selectedCuisine: this.fb.control(''),
		})
	}


  processForm() {

    const cuisine = this.form.value 

    this.restaurantSvc.getCuisineList(cuisine)
      .then(response => {
        this.form = this.createForm()

      })
      .catch(error => {
        console.error('>>> Error', error)
      })

  }

}
