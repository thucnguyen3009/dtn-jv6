package dtn.asm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dtn.asm.entity.Cart;

public interface CartDAO extends JpaRepository<Cart, String> {

}
