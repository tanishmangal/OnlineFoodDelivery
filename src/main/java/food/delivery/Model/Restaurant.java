package food.delivery.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer restaurant_id;
	
	@NotNull(message = "Restaurant name is not null")
    private String restaurant_nameString;
	
	@NotNull(message = "manager name is not null")
    private String mangaer_name;
	
	@NotNull
	@Pattern(regexp = "[6789]{3}[0-9]{7}" ,message = "Invalid No" )
    private String contact_No;
	
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
    private List<Item> item_list=new ArrayList<>();
}
