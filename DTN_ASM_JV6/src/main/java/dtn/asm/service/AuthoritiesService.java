package dtn.asm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dtn.asm.entity.Authorities;

public interface AuthoritiesService {
	List<Authorities> findAll();

	Authorities findById(Integer id);

	void create(Authorities entity);

	void update(Authorities entity);

	void delete(Integer id);
}
