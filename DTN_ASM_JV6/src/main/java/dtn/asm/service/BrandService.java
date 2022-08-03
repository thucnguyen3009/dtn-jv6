package dtn.asm.service;

import java.util.List;

import dtn.asm.entity.Brand;

public interface BrandService {
	List<Brand> findAll();

	Brand findById(Integer id);

	void create();

	void update();

	void delete(Integer id);
}
