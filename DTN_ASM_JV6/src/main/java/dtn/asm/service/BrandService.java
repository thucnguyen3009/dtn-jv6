package dtn.asm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dtn.asm.entity.Brand;

public interface BrandService {
	List<Brand> findAll();

	Brand findById(Integer id);

	void create(Brand entity);

	void update(Brand entity);

	void delete(Integer id);
}