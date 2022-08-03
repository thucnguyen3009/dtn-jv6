package dtn.asm.service;

import java.util.List;

import dtn.asm.entity.Favorites;

public interface FavoritesService {
	List<Favorites> findAll();

	Favorites findById(Integer id);

	void create();

	void update();

	void delete(Integer id);
}
