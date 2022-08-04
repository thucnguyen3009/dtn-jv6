package dtn.asm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dtn.asm.dao.OrderDetailsDAO;
import dtn.asm.entity.OrderDetails;
import dtn.asm.service.OrderDetailsService;
@Service
public class OrderDetailsServiceImp implements OrderDetailsService {

	@Autowired
	OrderDetailsDAO dao;
	
	@Override
	public List<OrderDetails> findAll() {
		return dao.findAll();
	}
	
	@Override
	public OrderDetails findById(Integer id) {
		return dao.getById(id);
	}
	
	@Override
	public void create(OrderDetails entity) {
		dao.save(entity);
	}
	@Override
	public void update(OrderDetails entity) {
		dao.save(entity);
	}
	@Override
	public void delete(Integer id) {
		dao.deleteById(id);
	}

}
