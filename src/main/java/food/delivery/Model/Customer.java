package food.delivery.Model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cusId;
	
	
	@NotNull
	@Pattern(regexp="[a-z]{6,12}", message = "Username must be between 6 to 12 characters. Must only contain lowercase characters.")
	private String cusName;
	

	@NotNull
	@Pattern(regexp="[a-zA-Z0-9]{6,12}",message="Password must contain between 6 to 12 characters. Must be alphanumeric with both Upper and lowercase characters.")
	private String custPassword;
	
	@NotNull
	@Pattern(regexp="[a-z]{3,12}", message = "First Name must not contains numbers or special characters")
	private String firstName;
	
	@NotNull
	@Pattern(regexp="[a-z]{3,12}", message = "Last Name must not contains numbers or special characters")
	private String lastName;
	
	@NotNull
	@Pattern(regexp="[6789]{3}[0-9]{7}", message = "invalid Mobile No ")
	private String mobileNumber;
	
	@Email
	@NotNull
	private String email;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Cart cart;
	

//	//@JsonIgnoreProperties("user")
//	@OneToOne(cascade = CascadeType.ALL)
//	private Login login;
//	

//	@JsonIgnoreProperties("user")
//	@OneToOne(cascade = CascadeType.ALL)
	//private Login login;
	
	@ManyToMany(cascade = CascadeType.ALL) 
	private List<Address> addresses = new ArrayList<>();

	
 
}
