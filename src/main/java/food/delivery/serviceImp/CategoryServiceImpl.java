package food.delivery.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import food.delivery.Model.Category;
import food.delivery.Model.Item;
import food.delivery.Reposotiory.CategoryRepo;
import food.delivery.ServiceInterface.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepo categoryRepo;

	@Override
	public Category addCategory(Category category) {
		for(Item item:	category.getItems()) {
			item.setCategory(category);
		}
	
		return categoryRepo.save(category);
	}


	@Override
	public Category removeCategory(Category cat) throws Exception {
		Optional<Category> category=categoryRepo.findById(cat.getCat_id());
		if(category.isEmpty()) {
			throw new Exception("Category Not Found");
		}
		categoryRepo.delete(category.get());
		return cat;
	}

	@Override
	public Category viewCategory(Category cat) throws Exception {
		Optional<Category> category=categoryRepo.findById(cat.getCat_id());
		if(category.isPresent()) {
			return category.get();
		}
		throw new Exception("Category Not Found");
	}

	@Override
	public List<Category> viewAllCategory() {
		return categoryRepo.findAll();
   }


	@Override
	public Category updateCategory(Integer id, String name) throws Exception {
		Optional<Category> category=categoryRepo.findById(id);
		if(category.isPresent()) {
			category.get().setCat_name(name);
			return category.get();
		}
		throw new Exception("Category Not Found");

	}
	 


}
