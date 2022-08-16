package food.delivery.Reposotiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import food.delivery.Model.Item;
import food.delivery.Model.Restaurant;


@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant, Integer> {
	@Query("from Restaurant r where r.city=?1")
	public List<Restaurant> getRestaurantByCity(String city);
}
