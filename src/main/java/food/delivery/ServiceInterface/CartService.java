package food.delivery.ServiceInterface;

import org.springframework.stereotype.Service;

import food.delivery.Dto.AddToCartDto;
import food.delivery.Model.Cart;
import food.delivery.Model.Item;

@Service
public interface CartService {
	  public Cart addItemToCart(AddToCartDto addToCartDto)throws Exception;;
	  public Cart increaseQuantity(Integer id,Integer itemID,Integer quantity)throws Exception;;
	  public Cart reduceQuantity(Integer id,Integer itemID,Integer quantity)throws Exception;;
	  public Cart removeItem(Integer cartId,Integer itemId)throws Exception;
	  public Cart clearCart(Integer id)throws Exception;
}
