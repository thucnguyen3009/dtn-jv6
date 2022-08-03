package dtn.asm.service;

import java.util.List;

import dtn.asm.entity.Cart;

public interface CartService {
	List<Cart> findAll();

	Cart findById(String id);

	void create();

	void update();

	void delete(String id);
}
