package dtn.asm.service;

import java.util.List;

import dtn.asm.entity.ProductColor;

public interface ProductColorService {
	List<ProductColor> findAll();

	ProductColor findById(Integer id);

	void create();

	void update();

	void delete(Integer id);
}
