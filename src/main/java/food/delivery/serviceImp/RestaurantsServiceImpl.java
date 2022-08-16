package food.delivery.serviceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import food.delivery.Model.Address;
import food.delivery.Model.Item;
import food.delivery.Model.Restaurant;
import food.delivery.Reposotiory.AddressRepo;
import food.delivery.Reposotiory.ItemRepo;
import food.delivery.Reposotiory.RestaurantRepo;
import food.delivery.ServiceInterface.RestaurantService;

@Service
public class RestaurantsServiceImpl implements RestaurantService{

	@Autowired
	private RestaurantRepo restaurantRepo;
	
	@Autowired
	private ItemRepo itemRepo;
	
	@Autowired
	private AddressRepo addressRepo;
	
	@Override
	public Restaurant addRestaurant(Restaurant res) {
			return restaurantRepo.save(res);
	}

	@Override
	public Restaurant updateRestaurant(Restaurant res) throws Exception {
		Optional<Restaurant> reOptional=restaurantRepo.findById(res.getRestaurant_id());
		if(!reOptional.isPresent()) {
			throw new Exception("Restaurant Not Find");
		}
		reOptional.get().setContact_No(res.getContact_No());
		reOptional.get().setMangaer_name(res.getMangaer_name());
		reOptional.get().setRestaurant_nameString(res.getRestaurant_nameString());
		return reOptional.get();
	}

	@Override
	public Restaurant removeRestaurant(Restaurant res) throws Exception {
		Optional<Restaurant> reOptional=restaurantRepo.findById(res.getRestaurant_id());
		if(!reOptional.isPresent()) {
			throw new Exception("Restaurant Not Find");
		}
		restaurantRepo.delete(reOptional.get());
		return reOptional.get();
	}

	@Override
	public Restaurant viewRestaurant(Restaurant res) throws Exception {
		Optional<Restaurant> reOptional=restaurantRepo.findById(res.getRestaurant_id());
		if(!reOptional.isPresent()) {
			throw new Exception("Restaurant Not Find");
		}
		return reOptional.get();
	}

	@Override
	public List<Restaurant> viewBearRestaurants(String city) throws Exception {
		List<Restaurant> resOptional=restaurantRepo.getRestaurantByCity(city);
		if(resOptional.size()==0) {
			throw new Exception ("In this Location not store any restaurant");
		}
		return resOptional;
	}

	@Override
	public List<Restaurant> viewRestaurantByItemName(String name) throws Exception {
		List<Item> items=itemRepo.getItemByName(name);
		if(items.size()==0) {
			throw new Exception("Item Not Found");
		}
		List<Restaurant> list=new ArrayList<>();
		for(Item item:items) {
			list.addAll( item.getRes_list());
		}
		return list;
	}

}
