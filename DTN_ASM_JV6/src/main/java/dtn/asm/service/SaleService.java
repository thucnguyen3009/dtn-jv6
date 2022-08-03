package dtn.asm.service;

import java.util.List;

import dtn.asm.entity.Sale;

public interface SaleService {
	List<Sale> findAll();

	Sale findById(Integer id);

	void create();

	void update();

	void delete(Integer id);
}
