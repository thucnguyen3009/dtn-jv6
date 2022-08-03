package dtn.asm.service;

import java.util.List;

import dtn.asm.entity.Address;

public interface AddressService {
	List<Address> findAll();

	Address findById(Integer id);

	void create();

	void update();

	void delete(Integer id);
}
