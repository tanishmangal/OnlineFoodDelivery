package food.delivery.Reposotiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import food.delivery.Model.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer> {

}
