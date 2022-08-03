package dtn.asm.service;

import java.util.List;

import dtn.asm.entity.Orders;

public interface OrdersService {
	List<Orders> findAll();

	Orders findById(Integer id);

	void create();

	void update();

	void delete(Integer id);
}
