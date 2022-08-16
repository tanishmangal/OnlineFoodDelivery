package food.delivery.Dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemtDto {
	private Integer id;
	
    @NotNull
	private String name;
	@NotNull
	private Integer price;
	@NotNull
	private Integer categoryId;

}
