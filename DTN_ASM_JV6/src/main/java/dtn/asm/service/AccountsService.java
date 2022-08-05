package dtn.asm.service;

import java.util.List;
import org.springframework.stereotype.Service;
import dtn.asm.entity.Accounts;

@Service
public interface AccountsService {
	
	List<Accounts> findAll();

	Accounts findById(String id);

	void create(Accounts entity);

	void update(Accounts entity);

	void delete(String id);
}
