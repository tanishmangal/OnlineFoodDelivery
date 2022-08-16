package food.delivery.Reposotiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import food.delivery.Model.Item;

@Repository
public interface ItemRepo extends JpaRepository<Item, Integer> {
	@Query("from Item i where i.name=?1")
	public List<Item> getItemByName(String name);
}
