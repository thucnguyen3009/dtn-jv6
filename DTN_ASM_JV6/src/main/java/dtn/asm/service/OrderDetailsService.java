package dtn.asm.service;

import java.util.List;

import dtn.asm.entity.OrderDetails;

public interface OrderDetailsService {
	List<OrderDetails> findAll();

	OrderDetails findById(Integer id);

	void create();

	void update();

	void delete(Integer id);
}
