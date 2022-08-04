package dtn.asm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dtn.asm.entity.Orders;

public interface OrdersService {
	List<Orders> findAll();

	Orders findById(Integer id);

	void create(Orders entity);

	void update(Orders entity);

	void delete(Integer id);
}
