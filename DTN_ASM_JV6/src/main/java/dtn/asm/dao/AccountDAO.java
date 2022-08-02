package dtn.asm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dtn.asm.entity.Accounts;

public interface AccountDAO extends JpaRepository<Accounts, String>{
	@Query (value="select * from Accounts where Email like ?1", nativeQuery = true )
	String findEmail(String email);
	
	@Query (value="select * from Accounts where Phone=?1", nativeQuery = true )
	String findPhone(String phone);
}
