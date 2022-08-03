package dtn.asm.service;

import java.util.List;

import dtn.asm.entity.Categories;

public interface CategoriesService {
	List<Categories> findAll();

	Categories findById(Integer id);

	void create();

	void update();

	void delete(Integer id);
}
