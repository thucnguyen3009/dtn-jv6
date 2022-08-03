package dtn.asm.service;

import java.util.List;

import dtn.asm.entity.Authorities;

public interface AuthoritiesService {
	List<Authorities> findAll();

	Authorities findById(Integer id);

	void create();

	void update();

	void delete(Integer id);
}
