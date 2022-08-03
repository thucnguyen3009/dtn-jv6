package dtn.asm.service;

import java.util.List;

import dtn.asm.entity.ProductImg;

public interface ProductImgService {
	List<ProductImg> findAll();

	ProductImg findById(Integer id);

	void create();

	void update();

	void delete(Integer id);
}
