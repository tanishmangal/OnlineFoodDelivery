package food.delivery.Dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddToCartDto {
    
	private Integer cusomerId;
	private Integer itemId;
	private Integer quantity;
}