import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http'
import { Injectable } from '@angular/core'
import { first, firstValueFrom, Subject } from 'rxjs'
import { Restaurant, Comment } from './models'


const BACKEND = 'https://csf-assessment.up.railway.app'

@Injectable()
export class RestaurantService {

	onSearchResults = new Subject<Restaurant[]>()
	onSearchQuery = new Subject<string>()


	constructor(private http: HttpClient){}

	// TODO Task 2 
	// Use the following method to get a list of cuisines
	// You can add any parameters (if any) and the return type 
	// DO NOT CHNAGE THE METHOD'S NAME
	// public getCuisineList(): Promise<Restaurant[]> {
		
	// 	return firstValueFrom(
	// 		this.http.get<Restaurant[]>('/api/cuisines')
	// 	  )
	// }
	public getCuisineList(): Promise<Restaurant[]> {
		return firstValueFrom(
		  this.http.get<Restaurant[]>(`${BACKEND}/api/cuisines`)
		).then(results => {
		  this.onSearchResults.next(results)
		  return results;
		})
	  }


	// TODO Task 3 
	// Use the following method to get a list of restaurants by cuisine
	// You can add any parameters (if any) and the return type 
	// DO NOT CHNAGE THE METHOD'S NAME
	public getRestaurantsByCuisine(cuisine: String): Promise<Restaurant[]> {
		return firstValueFrom(
			this.http.get<Restaurant[]>(`/api/${cuisine}/restaurants`)
		)
	}
	
	// TODO Task 4
	// Use this method to find a specific restaurant
	// You can add any parameters (if any) 
	// DO NOT CHNAGE THE METHOD'S NAME OR THE RETURN TYPE
	public getRestaurant(restaurant: String): Promise<Restaurant> {

		return firstValueFrom(
			this.http.get<Restaurant>(`/api/${restaurant}`)
		)

	}

	// TODO Task 5
	// Use this method to submit a comment
	// DO NOT CHANGE THE METHOD'S NAME OR SIGNATURE
	public postComment(comment: Comment): Promise<any> {

		const url = '/api/comments'


		const qs = new HttpParams()
			  .set("name", comment.name)
			  .set("rating", comment.rating)
			  .set("restaurantId", comment.restaurantId)
			  .set("text", comment.text)
	
		const headers = new HttpHeaders()
			.set('Content-Type', 'application/x-www-form-urlencoded')
	
		  return firstValueFrom(
			this.http.post<any>(url, qs.toString(), { headers })
		  )

	}
}
