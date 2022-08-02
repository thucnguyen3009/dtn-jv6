package dtn.asm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dtn.asm.entity.Products;

public interface ProductsDAO extends JpaRepository<Products, Integer> {


}
