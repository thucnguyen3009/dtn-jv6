package dtn.asm.service;

import java.util.List;

import dtn.asm.entity.Accounts;

public interface AccountsService {
	List<Accounts> findAll();

	Accounts findById(String id);

	void create();

	void update();

	void delete(String id);
}
