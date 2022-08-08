package dtn.asm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dtn.asm.entity.Orders;
import dtn.asm.entity.Sale;

public interface OrdersDAO extends JpaRepository<Orders, Integer> {

	List<Orders> findBySaleId(Sale saleId);
	
}
