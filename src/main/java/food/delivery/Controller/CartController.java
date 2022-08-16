package food.delivery.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import food.delivery.Dto.AddToCartDto;
import food.delivery.Model.Cart;
import food.delivery.ServiceInterface.CartService;

@RestController
@RequestMapping("foodPanda/cart")
public class CartController {

	@Autowired
	private CartService cartService;

	@PostMapping("/add/item")
	public ResponseEntity<Cart> addItemToCart(@RequestBody AddToCartDto addToCartDto) throws Exception {
		Cart cart = cartService.addItemToCart(addToCartDto);
		return new ResponseEntity<Cart>(cart, HttpStatus.CREATED);

	}

	@PutMapping("/item/increase")
	public ResponseEntity<Cart> increaseQuantity(@RequestParam Integer cartId, @RequestParam Integer itemId,
			@RequestParam Integer quantity) throws Exception {
		Cart cart = cartService.increaseQuantity(cartId, itemId, quantity);
		return new ResponseEntity<Cart>(cart, HttpStatus.ACCEPTED);

	}

	@PutMapping("/item/reduce")
	public ResponseEntity<Cart> reduceQuantity(@RequestParam Integer cartId, @RequestParam Integer itemId,
			@RequestParam Integer quantity) throws Exception {
		Cart cart = cartService.reduceQuantity(cartId, itemId, quantity);
		return new ResponseEntity<Cart>(cart, HttpStatus.ACCEPTED);

	}

	@PutMapping("/item/remove")
	public ResponseEntity<Cart> removeitem(@RequestParam Integer cartId, @RequestParam Integer itemId)
			throws Exception {
		Cart cart = cartService.removeItem(cartId, itemId);
		return new ResponseEntity<Cart>(cart, HttpStatus.ACCEPTED);

	}

	@DeleteMapping("/clear")
	public ResponseEntity<Cart> clearCart(@RequestParam Integer cartId) throws Exception {
		Cart cart = cartService.clearCart(cartId);
		return new ResponseEntity<Cart>(cart, HttpStatus.ACCEPTED);

	}

}
