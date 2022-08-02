package dtn.asm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dtn.asm.entity.Orders;

public interface OrdersDAO extends JpaRepository<Orders, Integer> {

}
