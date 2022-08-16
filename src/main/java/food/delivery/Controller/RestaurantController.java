package food.delivery.Controller;

import java.util.List;

import org.hibernate.type.TrueFalseType;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import food.delivery.Model.Address;
import food.delivery.Model.Restaurant;
import food.delivery.ServiceInterface.RestaurantService;


@RestController
@RequestMapping("/foodpanda/restaurant")
public class RestaurantController {

@Autowired
private RestaurantService restaurantService;
	
	@PostMapping("/add")
	public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant) throws Exception {
		Restaurant restaurants=restaurantService.addRestaurant(restaurant);
		return new ResponseEntity<Restaurant>(restaurants,HttpStatus.CREATED);
	}
	@PutMapping("/update")
	public ResponseEntity<Restaurant> updateRestaurant(@RequestBody Restaurant restaurant)throws Exception {
		Restaurant restaurant2=restaurantService.updateRestaurant(restaurant);
		return new ResponseEntity<Restaurant>(restaurant2,HttpStatus.OK);
	}
	@DeleteMapping("/remove")
	public ResponseEntity<Restaurant> removeRestaurant(@RequestBody Restaurant restaurant)throws Exception {
		Restaurant restaurant2=restaurantService.removeRestaurant(restaurant);
		return new ResponseEntity<Restaurant >(restaurant2,HttpStatus.OK);
	}
	
	@GetMapping("/view")
	public ResponseEntity<Restaurant> viewRestaurant(@RequestBody Restaurant restaurant)throws Exception {
		Restaurant restaurant2=restaurantService.viewRestaurant(restaurant);
		return new ResponseEntity<Restaurant >(restaurant2,HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Restaurant>> viewAllRestaurant(@RequestParam String city)throws Exception {
		List<Restaurant> restaurant2=restaurantService.viewBearRestaurants(city);
		return new ResponseEntity<List<Restaurant>>(restaurant2,HttpStatus.OK);
	}
	@GetMapping("/{name}")
	public ResponseEntity<List<Restaurant>> viewAllRestaurantByName(@PathVariable String name)throws Exception {
		List<Restaurant> restaurant2=restaurantService.viewRestaurantByItemName(name);
		return new ResponseEntity<List<Restaurant>>(restaurant2,HttpStatus.OK);
	}

}
