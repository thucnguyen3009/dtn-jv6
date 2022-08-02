package dtn.asm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dtn.asm.entity.OrderDetails;

public interface OrderDetailsDAO extends JpaRepository<OrderDetails, Integer> {

}
