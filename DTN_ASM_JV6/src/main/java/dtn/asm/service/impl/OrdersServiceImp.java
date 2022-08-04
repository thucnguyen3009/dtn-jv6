package dtn.asm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dtn.asm.dao.OrdersDAO;
import dtn.asm.entity.Orders;
import dtn.asm.service.OrdersService;
@Service
public class OrdersServiceImp implements OrdersService {

	@Autowired
	OrdersDAO dao;
	
	@Override
	public List<Orders> findAll() {
		return dao.findAll();
	}
	
	@Override
	public Orders findById(Integer id) {
		return dao.getById(id);
	}
	
	@Override
	public void create(Orders entity) {
		dao.save(entity);
	}
	
	@Override
	public void update(Orders entity) {
		dao.save(entity);
	}

	@Override
	public void delete(Integer id) {
		dao.deleteById(id);
	}
}
