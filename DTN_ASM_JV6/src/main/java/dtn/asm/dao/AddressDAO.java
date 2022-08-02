package dtn.asm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dtn.asm.entity.Address;

public interface AddressDAO extends JpaRepository<Address, Integer> {

}
