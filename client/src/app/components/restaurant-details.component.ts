import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import {ErrorStateMatcher} from '@angular/material/core';
import { RestaurantService } from '../restaurant-service';


@Component({
  selector: 'app-restaurant-details',
  templateUrl: './restaurant-details.component.html',
  styleUrls: ['./restaurant-details.component.css']
})
export class RestaurantDetailsComponent implements OnInit{	
	// TODO Task 4 and Task 5
	// For View 3

  form!: FormGroup
  constructor(private fb: FormBuilder, private restaurantSvc: RestaurantService){}

  ngOnInit(): void {
    this.form = this.createForm()
}


createForm(): FormGroup {
  return this.fb.group({
    name: this.fb.control(''),
  })
}


  submit() {
    const comments = this.form.value 

    this.restaurantSvc.postComment(comments)
      .then(response => {
        this.form = this.createForm()

      })
      .catch(error => {
        console.error('>>> Error', error)
      })
  }
}
