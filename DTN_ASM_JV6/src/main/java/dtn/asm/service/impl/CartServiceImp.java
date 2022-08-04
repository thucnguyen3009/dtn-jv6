package dtn.asm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dtn.asm.dao.CartDAO;
import dtn.asm.entity.Cart;
import dtn.asm.service.CartService;
@Service
public class CartServiceImp implements CartService {

	@Autowired
	CartDAO dao;
	
	@Override
	public List<Cart> findAll() {
		return dao.findAll();
	}
	
	@Override
	public Cart findById(String id) {
		return dao.getById(id);
	}
	
	@Override
	public void create(Cart entity) {
		dao.save(entity);
	}
	
	@Override
	public void update(Cart entity) {
		dao.save(entity);
	}
	
	@Override
	public void delete(String id) {
		dao.deleteById(id);
	}

}
