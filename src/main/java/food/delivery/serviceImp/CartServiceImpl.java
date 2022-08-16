package food.delivery.serviceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import food.delivery.Dto.AddToCartDto;
import food.delivery.Dto.ItemWithQuantity;
import food.delivery.Model.Cart;
import food.delivery.Model.Customer;
import food.delivery.Model.Item;
import food.delivery.Reposotiory.CartRepo;
import food.delivery.Reposotiory.CustomerRepo;
import food.delivery.Reposotiory.ItemRepo;
import food.delivery.ServiceInterface.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepo cartRepo;
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private ItemRepo itemRepo;

	@Override
	public Cart addItemToCart(AddToCartDto addToCartDto) throws Exception {
		Optional<Item> itemm=itemRepo.findById(addToCartDto.getItemId());
        Optional<Customer> customerOptional=customerRepo.findById(addToCartDto.getCusomerId());
		if (!customerOptional.isPresent()) {
			throw new Exception("Customer Id Is invalid ");
		}else if(!itemm.isPresent()) {
			throw new Exception("Product Not found");
		}else {
			Optional<Cart> cartOptional=cartRepo.findById(customerOptional.get().getCusId());
			if(!cartOptional.isPresent()) {
				Cart catCart=new Cart();
				catCart.setCustomer(customerOptional.get());
				List<ItemWithQuantity> listt=catCart.getItemList();
				listt.add(new ItemWithQuantity(itemm.get(), addToCartDto.getQuantity()));
				
			}else {
				boolean itemInList=false;
				for(ItemWithQuantity itemWithQuantity : cartOptional.get().getItemList()) {
					if(itemWithQuantity.getItem().getItem_id()==itemm.get().getItem_id()) {
						itemWithQuantity.setQuantity((itemWithQuantity.getQuantity()+addToCartDto.getQuantity()));
						itemInList=true;
						break;
					}
				}
				if(!itemInList) {
					cartOptional.get().getItemList().add(new ItemWithQuantity(itemm.get(), addToCartDto.getQuantity()));
     			}
			}
		}
		
		return customerOptional.get().getCart();
	}

	@Override
	public Cart increaseQuantity(Integer cartId, Integer itemID, Integer quantity) throws Exception {
		Optional<Item> itemm=itemRepo.findById(itemID);
		Optional<Cart> cartOptional=cartRepo.findById(cartId);
		
		if (!cartOptional.isPresent()) {
			throw new Exception("Cart Id Is invalid ");
		}else if(!itemm.isPresent()) {
			throw new Exception("Product Id is Invalid");
		}else {
			boolean itemInList=false;
			for(ItemWithQuantity itemWithQuantity : cartOptional.get().getItemList()) {
				if(itemWithQuantity.getItem().getItem_id()==itemm.get().getItem_id()) {
					itemWithQuantity.setQuantity((itemWithQuantity.getQuantity()+quantity));
					itemInList=true;
					break;
				}
		   }
			if(!itemInList) {
				cartOptional.get().getItemList().add(new ItemWithQuantity(itemm.get(),quantity));
			}
		}
		return cartOptional.get();
		
	}

	@Override
	public Cart reduceQuantity(Integer cartId, Integer itemID, Integer quantity) throws Exception {
		Optional<Item> itemm=itemRepo.findById(itemID);
		Optional<Cart> cartOptional=cartRepo.findById(cartId);
		
		if (!cartOptional.isPresent()) {
			throw new Exception("Cart Id Is invalid ");
		}else if(!itemm.isPresent()) {
			throw new Exception("Product Id is Invalid");
		}else {
			boolean itemInList=false;
			for(ItemWithQuantity itemWithQuantity : cartOptional.get().getItemList()) {
				if(itemWithQuantity.getItem().getItem_id()==itemm.get().getItem_id()) {
					itemWithQuantity.setQuantity((itemWithQuantity.getQuantity()-quantity));
					if(itemWithQuantity.getQuantity()<=0) {
						cartOptional.get().getItemList().remove(itemWithQuantity);
					}
					itemInList=true;
					break;
				}
		   }
			if(!itemInList) {
				throw new Exception("Product is not in cart");
			}
		}
		return cartOptional.get();
	}

	@Override
	public Cart removeItem(Integer cartId, Integer itemId) throws Exception {
		Optional<Item> itemm=itemRepo.findById(itemId);
		Optional<Cart> cartOptional=cartRepo.findById(cartId);
		
		if (!cartOptional.isPresent()) {
			throw new Exception("Cart Id Is invalid ");
		}else if(!itemm.isPresent()) {
			throw new Exception("Product Id is Invalid");
		}else {
			boolean itemInList=false;
			for(ItemWithQuantity itemWithQuantity : cartOptional.get().getItemList()) {
				if(itemWithQuantity.getItem().getItem_id()==itemm.get().getItem_id()) {
						cartOptional.get().getItemList().remove(itemWithQuantity);
					}
					itemInList=true;
					break;
			}
			if(!itemInList) {
				throw new Exception("Product is not in cart");
			}
		}
		return cartOptional.get();
	}

	@Override
	public Cart clearCart(Integer cartId) throws Exception {
		Optional<Cart> cartOptional=cartRepo.findById(cartId);
		if (!cartOptional.isPresent()) {
			throw new Exception("Cart Id Is invalid ");
		}else {
			cartOptional.get().setItemList(new ArrayList<>());
		}
		return cartOptional.get();
	}

	

}
