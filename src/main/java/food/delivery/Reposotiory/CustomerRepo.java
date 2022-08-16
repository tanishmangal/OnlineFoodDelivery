package food.delivery.Reposotiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import food.delivery.Model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}
