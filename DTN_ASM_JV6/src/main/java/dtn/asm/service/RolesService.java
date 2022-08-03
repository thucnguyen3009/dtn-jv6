package dtn.asm.service;

import java.util.List;

import dtn.asm.entity.Roles;

public interface RolesService {
	List<Roles> findAll();

	Roles findById(String id);

	void create();

	void update();

	void delete(String id);
}
