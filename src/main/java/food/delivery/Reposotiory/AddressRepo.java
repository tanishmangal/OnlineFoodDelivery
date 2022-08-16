package food.delivery.Reposotiory;

import org.springframework.data.jpa.repository.JpaRepository;

import food.delivery.Model.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {

}
