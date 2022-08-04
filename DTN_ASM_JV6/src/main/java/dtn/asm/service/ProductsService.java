package dtn.asm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dtn.asm.entity.Products;

@Service
public interface ProductsService {
	List<Products> findAll();

	Products findById(Integer id);

	void create(Products entity);

	void update(Products entity);

	void delete(Integer id);
}
