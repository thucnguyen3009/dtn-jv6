package dtn.asm.service;

import java.util.List;

import dtn.asm.entity.Color;

public interface ColorService {
	List<Color> findAll();

	Color findById(Integer id);

	void create();

	void update();

	void delete(Integer id);
}
