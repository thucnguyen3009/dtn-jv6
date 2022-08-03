package dtn.asm.service;

import java.util.List;

import dtn.asm.entity.PriceHistory;

public interface PriceHistoryService {
	List<PriceHistory> findAll();

	PriceHistory findById(Integer id);

	void create();

	void update();

	void delete(Integer id);
}
