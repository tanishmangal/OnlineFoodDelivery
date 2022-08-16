package food.delivery.ServiceInterface;

import java.util.List;

import food.delivery.Model.Category;

public interface CategoryService {
	public Category addCategory(Category category);

	public Category updateCategory(Integer id,String name) throws Exception;

	public Category removeCategory(Category cat)throws Exception;

	public Category viewCategory(Category cat) throws Exception;

	public List<Category> viewAllCategory();
}
