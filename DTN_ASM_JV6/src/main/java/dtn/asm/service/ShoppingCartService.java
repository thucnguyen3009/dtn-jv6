package dtn.asm.service;

import java.util.List;

import dtn.asm.entity.Accounts;
import dtn.asm.entity.Cart;
import dtn.asm.entity.Products;


public interface ShoppingCartService {
	void add(Integer id, Products pro, int qty,Accounts acc);

	Cart update(Integer id, int qty);

	void clear();

	List<Cart> getCarts(Accounts acc);

	int getCount();

	double getAmount();

	void remove(Integer id);

}
