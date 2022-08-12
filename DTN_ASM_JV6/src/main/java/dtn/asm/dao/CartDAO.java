package dtn.asm.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dtn.asm.entity.Accounts;
import dtn.asm.entity.Cart;
import dtn.asm.entity.Products;

public interface CartDAO extends JpaRepository<Cart, String> {
	List<Cart> findByUserCart(Accounts userCart);
	Optional<Cart> findByProCart(Products proCart);
}
