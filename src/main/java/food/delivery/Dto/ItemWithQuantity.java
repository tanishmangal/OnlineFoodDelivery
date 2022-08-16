package food.delivery.Dto;

import javax.persistence.Embeddable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import food.delivery.Model.Cart;
import food.delivery.Model.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemWithQuantity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idInteger;

	
	@OneToOne
	private Item item;
	private Integer quantity;
	
	public ItemWithQuantity(Item item, Integer quantity) {
		this.item = item;
		this.quantity = quantity;
	}
	

	
}
