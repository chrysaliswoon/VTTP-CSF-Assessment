package vttp2022.csf.assessment.server.repositories;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import vttp2022.csf.assessment.server.models.Comment;
import vttp2022.csf.assessment.server.models.Restaurant;

@Repository
public class RestaurantRepository {

	//? Imports the MongoTemplate to access the MongoDB Database
	@Autowired
	private MongoTemplate template;

	String C_COLLECTION = "restaurants";

	// TODO Task 2
	// Use this method to retrive a list of cuisines from the restaurant collection
	// You can add any parameters (if any) and the return type 
	// DO NOT CHANGE THE METHOD'S NAME
	// Write the Mongo native query above for this method
	//  

	/*
	 * db.getCollection("restaurants").distinct("cuisine")
	 */
	public Optional<Restaurant> getCuisines(String searchQuery) {

		List<String> result = template.findDistinct(new Query(), searchQuery, C_COLLECTION, String.class);
		if (null == result)
			return Optional.empty();

		Restaurant restaurant = new Restaurant();
		restaurant.setCuisine(((Document) result).getString("cuisine"));


		return Optional.of(restaurant);
	}

	// TODO Task 3
	// Use this method to retrive a all restaurants for a particular cuisine
	// You can add any parameters (if any) and the return type 
	// DO NOT CHNAGE THE METHOD'S NAME
	// Write the Mongo native query above for this method
	//  


	/*
	 * db.getCollection("restaurants").find({cuisine: "Bakery"}).sort({name:1})
	 */
	public Optional<List<Document>> getRestaurantsByCuisine(String cuisineType) {

		Sort sort = Sort.by(Sort.Direction.ASC, "name");
		Criteria criteria = Criteria.where("cuisine").is(cuisineType);
		Query query = Query.query(criteria);
		
		List<Document> result = template.find(query, Document.class, C_COLLECTION);
		
		return Optional.of(result);

	}

	// TODO Task 4
	// Use this method to find a specific restaurant
	// You can add any parameters (if any) 
	// DO NOT CHNAGE THE METHOD'S NAME OR THE RETURN TYPE
	// Write the Mongo native query above for this method
	//  

	/*
	 * db.getCollection("restaurants").find({name: "Caffe Roma"})
	 */
	public Optional<List<Document>> getRestaurant(String restaurantName) {

		Criteria criteria = Criteria.where("name").is(restaurantName);
		Query query = Query.query(criteria);
		
		List<Document> result = template.find(query, Document.class, C_COLLECTION);
		
		return Optional.of(result);
		
	}

	// TODO Task 5
	// Use this method to insert a comment into the restaurant database
	// DO NOT CHNAGE THE METHOD'S NAME OR THE RETURN TYPE
	// Write the Mongo native query above for this method
	//  

	/*
	*   db.getCollection("restaurants").insert({
		name: "Caffe Roma",
		comment: ["Brews aromatic coffee", "Has long waiting time"]
		})
	 */
	public void addComment(Comment comment) {

		Document comments = new Document();
		comments.put("name", comment.getName());
		comments.put("rating", comment.getRating());
		comments.put("restaurantId", comment.getRestaurantId());
		comments.put("text", comment.getText());


		Document inserted = template.insert(comments, "comment");


}
}