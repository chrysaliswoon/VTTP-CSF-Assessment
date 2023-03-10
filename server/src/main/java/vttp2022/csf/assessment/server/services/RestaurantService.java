package vttp2022.csf.assessment.server.services;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp2022.csf.assessment.server.models.Comment;
import vttp2022.csf.assessment.server.models.Restaurant;
import vttp2022.csf.assessment.server.repositories.MapCache;
import vttp2022.csf.assessment.server.repositories.RestaurantRepository;

@Service
public class RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepo;

	@Autowired
	private MapCache mapCache;

	// TODO Task 2 
	// Use the following method to get a list of cuisines 
	// You can add any parameters (if any) and the return type 
	// DO NOT CHANGE THE METHOD'S NAME
	public List<String> getCuisines() {
		System.out.println("Getting list of cuisines from Services");

		List<String> cuisines = restaurantRepo.getCuisines();

		System.out.println(cuisines);
		return cuisines;

	}

	// TODO Task 3 
	// Use the following method to get a list of restaurants by cuisine
	// You can add any parameters (if any) and the return type 
	// DO NOT CHNAGE THE METHOD'S NAME
	public List<Restaurant> getRestaurantsByCuisine(String cuisineType) {

		System.out.println("Getting list of restaurants by cuisine from Services");

		return restaurantRepo.getRestaurantsByCuisine(cuisineType);
	}

	// TODO Task 4
	// Use this method to find a specific restaurant
	// You can add any parameters (if any) 
	// DO NOT CHNAGE THE METHOD'S NAME OR THE RETURN TYPE
	public List<Restaurant> getRestaurant(String restaurantName) {

		System.out.println("Getting specific restaurant by cuisine from Services");

		return restaurantRepo.getRestaurant(restaurantName);
		
	}

	// TODO Task 5
	// Use this method to insert a comment into the restaurant database
	// DO NOT CHNAGE THE METHOD'S NAME OR THE RETURN TYPE
	public void addComment(Comment comment) {
		restaurantRepo.addComment(comment);
	}

	//
	// You may add other methods to this class
}
