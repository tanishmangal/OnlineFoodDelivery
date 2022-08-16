package food.delivery.ServiceInterface;

import java.util.List;

import food.delivery.Dto.ItemtDto;
import food.delivery.Model.Category;
import food.delivery.Model.Item;
import food.delivery.Model.Restaurant;

public interface ItemService {
	public Item addItem(ItemtDto item,Category category);

	public Item updateItem(ItemtDto item,Item item2) throws Exception;

	public Item removeItem(Integer id) throws Exception;

	public Item viewItem(Item item)throws Exception;

	public List<Item> viewAllItem(Category cat) throws Exception;

	public List<Item> viewAllItem(Restaurant res);

	public List<Item> viewAllItemByName(String name) throws Exception;
}
