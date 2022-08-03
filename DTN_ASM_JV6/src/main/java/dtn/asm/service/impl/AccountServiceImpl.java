package dtn.asm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dtn.asm.dao.AccountDAO;
import dtn.asm.entity.Accounts;
import dtn.asm.service.AccountsService;

public class AccountServiceImpl implements AccountsService {
	@Autowired
	AccountDAO dao;

	@Override
	public List<Accounts> findAll() {
		
		return dao.findAll();
	}

	@Override
	public Accounts findById(String id) {
		return dao.findById(id).get();
	}

	@Override
	public void create() {
		
	}

	@Override
	public void update() {
		
	}

	@Override
	public void delete(String id) {
		dao.delete(this.findById(id));
	}

}
