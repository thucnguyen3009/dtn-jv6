package dtn.asm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dtn.asm.entity.OrderDetails;

public interface OrderDetailsService {
	List<OrderDetails> findAll();

	OrderDetails findById(Integer id);

	void create(OrderDetails entity);

	void update(OrderDetails entity);

	void delete(Integer id);
}
