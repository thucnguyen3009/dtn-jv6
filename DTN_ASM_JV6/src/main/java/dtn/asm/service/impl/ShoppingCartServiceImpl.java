package dtn.asm.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dtn.asm.entity.Accounts;
import dtn.asm.entity.Cart;
import dtn.asm.entity.Products;
import dtn.asm.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
	@Autowired
	CartServiceImp cartService;

	@Override
	public void add(Integer id, Products pro, int qty, Accounts acc) {
		Optional<Cart> cart =cartService.findByProduct(pro);
		Cart cart1 = new Cart();
		if(cart.isPresent()) {
			cart1 = cart.get();
			cart1.setQty(cart1.getQty()+qty);
			cartService.update(cart1);
		}else {
		cart1.setProCart(pro);
		cart1.setColorCart(pro.getProductColors().get(0).getColor());
		cart1.setPrice(pro.getPrice());
		cart1.setUserCart(acc);
		cartService.create(cart1);}
	}

	@Override
	public void remove(Integer id) {

	}

	@Override
	public Cart update(Integer id, int qty) {
		return null;
	}

	@Override
	public void clear() {
	}

	@Override
	public List<Cart> getCarts(Accounts acc) {
		return cartService.findByUsername(acc);
	}

	@Override
	public int getCount() {
		return 0;
	}

	@Override
	public double getAmount() {
		return 0.0;
	}

}
