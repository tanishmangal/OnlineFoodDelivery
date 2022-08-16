
package food.delivery.ServiceInterface;

import java.util.List;

import food.delivery.Model.Address;
import food.delivery.Model.Restaurant;

public interface RestaurantService {
	public Restaurant addRestaurant(Restaurant res);
	public Restaurant updateRestaurant(Restaurant res) throws Exception;
	public Restaurant removeRestaurant(Restaurant res) throws Exception ;
	public Restaurant viewRestaurant(Restaurant res)throws Exception;
	public List<Restaurant> viewBearRestaurants(String city)throws Exception;
	public List<Restaurant> viewRestaurantByItemName(String name)throws Exception;
}
