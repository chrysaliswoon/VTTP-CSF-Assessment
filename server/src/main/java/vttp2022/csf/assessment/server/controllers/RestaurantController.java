package vttp2022.csf.assessment.server.controllers;

import java.util.List;
import java.util.Optional;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import vttp2022.csf.assessment.server.models.Comment;
import vttp2022.csf.assessment.server.models.Restaurant;
import vttp2022.csf.assessment.server.services.RestaurantService;

@Controller
@RequestMapping(path = "/api")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    /*
     * Task 2
     * GET /api/cuisines
     * Accept: application/json
     */

    @GetMapping(path = "/cuisines")
    @ResponseBody
    public ResponseEntity<String> getCuisines() {
        List<String> opt = restaurantService.getCuisines();
        
        if (opt.isEmpty())
            return new ResponseEntity<String>("Unable to get search results!", HttpStatus.NOT_FOUND);
            
        return new ResponseEntity<String>(opt.toString(), HttpStatus.OK);
    }

    /*
     * Task 3
     * GET /api/{cuisine}/restaurants
     * Accept: application/json
     */

     @GetMapping(path = "/{cuisine}/restaurants")
     @ResponseBody
     public ResponseEntity<String> getRestaurantByCuisine(@PathVariable String cuisine) {

        List<Restaurant> restaurants = restaurantService.getRestaurantsByCuisine(cuisine);

        return ResponseEntity.ok(restaurants.toString());

        //  Optional<Restaurant> opt = restaurantService.getCuisines(cuisine);
        //  if (opt.isEmpty())
        //     return new ResponseEntity<String>("Unable to get search results!", HttpStatus.NOT_FOUND);
             
        //  return new ResponseEntity<String>(opt.toString(), HttpStatus.OK);
     }


     @GetMapping(path = "/{restaurantName}")
     @ResponseBody
     public ResponseEntity<String> getRestaurant(@PathVariable String restaurantName) {

        List<Restaurant> specificRestaurant = restaurantService.getRestaurant(restaurantName);

        return ResponseEntity.ok(specificRestaurant.toString());

        //  List<Restaurant> opt = restaurantService.getRestaurant(restaurantName);
        //  if (opt.isEmpty())
        //     return new ResponseEntity<String>("Unable to get search results!", HttpStatus.NOT_FOUND);
             
        //  return new ResponseEntity<String>(opt.toString(), HttpStatus.OK);
     }
    


    /*
     * Task 4
     * GET /map?lat=<latitude>&lng=<longitude>
     * Accept: image/png
     */
     


    

    /*
     * Task 5
     * POST /api/comments
     * Content-Type: application/json
     * Accept: application/json
     */

	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> postPostJson(@RequestPart String name, @RequestPart Integer rating, @RequestPart String text) {

		Comment comment = new Comment();
		comment.setName(name);
		comment.setRating(rating);
		comment.setText(text);

		restaurantService.addComment(comment);

		return ResponseEntity.ok(comment.toString());
	}

 



    


    



    
}
