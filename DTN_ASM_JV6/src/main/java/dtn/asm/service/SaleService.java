package dtn.asm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dtn.asm.entity.Sale;

public interface SaleService {
	List<Sale> findAll();

	Sale findById(Integer id);

	void create(Sale entity);

	void update(Sale entity);

	void delete(Integer id);
}
