package food.delivery.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import food.delivery.Dto.ItemtDto;
import food.delivery.Model.Category;
import food.delivery.Model.Item;
import food.delivery.Model.Restaurant;
import food.delivery.Reposotiory.CategoryRepo;
import food.delivery.Reposotiory.ItemRepo;
import food.delivery.ServiceInterface.ItemService;



@RestController
@RequestMapping("foodpanda/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	CategoryRepo categoryRepo;
	
	@Autowired
	ItemRepo itemRepo;

	@PostMapping("/add")
	public ResponseEntity<Item> addItem(@RequestBody ItemtDto itemDto)throws Exception {
		Optional<Category>optionalCat=categoryRepo.findById(itemDto.getCategoryId());
		if(optionalCat.isPresent()) {
			Item item=itemService.addItem(itemDto,optionalCat.get());
			return new ResponseEntity<Item>(item, HttpStatus.OK);
		}
		throw new Exception("Category Does not Exist");
		

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Item> updateItem(@RequestBody ItemtDto itemtDto,@PathVariable Integer id)throws Exception {
		Optional<Item> optionalItem=itemRepo.findById(id);
		if(optionalItem.isPresent()) {
			Item item2=itemService.updateItem(itemtDto, optionalItem.get());
			return new ResponseEntity<Item>(item2, HttpStatus.OK);
		}
		
		 throw new Exception("Item  Does not Exist");

	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Item> removeItem(@PathVariable Integer id)throws Exception {
		Item item2 = itemService.removeItem(id);
		return new ResponseEntity<Item>(item2, HttpStatus.OK);

	}

	@GetMapping("/view")
	public ResponseEntity<Item> viewItem(@RequestBody Item item)throws Exception {
		Item item2 = itemService.viewItem(item);
		return new ResponseEntity<Item>(item2, HttpStatus.OK);

	}

	@GetMapping("/view/all")
	public ResponseEntity<List<Item>> viewAllItems(@RequestBody Category category)throws Exception {
		List<Item> items = itemService.viewAllItem(category);
		return new ResponseEntity<List<Item>>(items, HttpStatus.OK);

	}

	@GetMapping("/views/all")
	public ResponseEntity<List<Item>> viewAllItems(@RequestBody Restaurant restaurant)throws Exception {
		List<Item> items = itemService.viewAllItem(restaurant);
		return new ResponseEntity<List<Item>>(items, HttpStatus.OK);

	}
	@GetMapping("/view/{name}")
	public ResponseEntity<List<Item>> viewAllItemsByName(@PathVariable String name)throws Exception {
		List<Item> items = itemService.viewAllItemByName(name);
		return new ResponseEntity<List<Item>>(items, HttpStatus.OK);

	}

}
