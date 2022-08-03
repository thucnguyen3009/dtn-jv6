package dtn.asm.service;

import java.util.List;

import dtn.asm.entity.Products;

public interface ProductsService {
	List<Products> findAll();

	Products findById(Integer id);

	void create();

	void update();

	void delete(Integer id);
}
