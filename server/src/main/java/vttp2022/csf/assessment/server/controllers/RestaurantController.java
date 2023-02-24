package vttp2022.csf.assessment.server.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import vttp2022.csf.assessment.server.models.Restaurant;
import vttp2022.csf.assessment.server.services.RestaurantService;

@Controller
@RequestMapping(path = "/api")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping(path = "/cuisines")
    @ResponseBody
    public ResponseEntity<String> getCuisines() {
        String searchQuery = "cuisines";
        Optional<Restaurant> opt = restaurantService.getCuisines(searchQuery);
        if (opt.isEmpty())
            return new ResponseEntity<String>("User login failed!", HttpStatus.NOT_FOUND);
            
        return new ResponseEntity<String>(opt.toString(), HttpStatus.OK);
        }


    
}
