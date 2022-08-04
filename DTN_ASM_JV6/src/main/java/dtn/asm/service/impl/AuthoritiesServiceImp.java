package dtn.asm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dtn.asm.dao.AuthoritiesDAO;
import dtn.asm.entity.Authorities;
import dtn.asm.service.AuthoritiesService;
@Service
public class AuthoritiesServiceImp implements AuthoritiesService{

	@Autowired
	AuthoritiesDAO dao;
	
	@Override
	public List<Authorities> findAll() {
		return dao.findAll();
	}
	@Override
	public Authorities findById(Integer id) {
		return dao.getById(id);
	}
	
	@Override
	public void create(Authorities entity) {
		dao.save(entity);
	}
	
	@Override
	public void update(Authorities entity) {
		dao.save(entity);
	}
	
	@Override
	public void delete(Integer id) {
		dao.deleteById(id);
	}

}
