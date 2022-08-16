package food.delivery.Reposotiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import food.delivery.Model.Category;
import food.delivery.Model.Item;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {
	

}
