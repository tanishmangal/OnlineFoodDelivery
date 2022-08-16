
package food.delivery.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Address {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer add_id;
	
	@NotNull(message = "area cant not be null")
	private String area;
	@NotNull(message = "City cannot be null")
	private String city;
	@NotNull(message = "State canot be null")
	private String state;
	@NotNull(message = "Pincode cannot be null")
	@Pattern(regexp = "[0-9]{6}", message = "Invalid Pincode")
	private String pincode;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Customer> customers;
	
	
	
	

}
