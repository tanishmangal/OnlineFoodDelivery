package food.delivery.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import food.delivery.Dto.ItemtDto;
import food.delivery.Model.Category;
import food.delivery.Model.Item;
import food.delivery.Model.Restaurant;
import food.delivery.Reposotiory.CategoryRepo;
import food.delivery.Reposotiory.ItemRepo;
import food.delivery.ServiceInterface.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	ItemRepo itemRepo;
	
	@Autowired
	CategoryRepo categoryRepo;

	@Override
	public Item addItem(ItemtDto item,Category category) {
		Item item2=new Item();
		item2.setName(item.getName());
		item2.setPrice(item.getPrice());
		item2.setCategory(category);
		category.getItems().add(item2);
		return itemRepo.save(item2);
	}

	@Override
	public Item updateItem(ItemtDto item,Item item2) throws Exception {
		item2.setName(item.getName());
		item2.setPrice(item.getPrice());
		return itemRepo.save(item2);
	}

	@Override
	public Item removeItem(Integer id) throws Exception {
	Optional<Item> item=itemRepo.findById(id);
	  if(item.isPresent()) {
		  itemRepo.delete(item.get());
		  return item.get();
	  }
		throw new Exception("Item Not Found");
	}

	@Override
	public Item viewItem(Item item) throws Exception {
		Optional<Item> item2=itemRepo.findById(item.getItem_id());
		if(item2.isPresent()) {
			 return item2.get();
		}
		throw new Exception("Item Not Found");
	}

	@Override
	public List<Item> viewAllItem(Category cat) throws Exception {
		Optional<Category> category=categoryRepo.findById(cat.getCat_id());
		if(category.isPresent()) {
			return category.get().getItems();
		}
		throw new Exception("Item Not Found");
		
	}

	@Override
	public List<Item> viewAllItem(Restaurant res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> viewAllItemByName(String name) throws Exception {
	  List<Item> list =itemRepo.getItemByName(name);
	  if(list.size()==0) {
		  throw new Exception("Not Found");
	  }
	  return list;
		
	}

}
