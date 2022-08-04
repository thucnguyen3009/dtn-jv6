package dtn.asm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dtn.asm.dao.BrandDAO;
import dtn.asm.entity.Brand;
import dtn.asm.service.BrandService;
@Service
public class BrandServiceImp implements BrandService {

	@Autowired
	BrandDAO dao;
	
	@Override
	public List<Brand> findAll() {
		return dao.findAll();
	}
	@Override
	public Brand findById(Integer id) {
		return dao.getById(id);
	}
	
	@Override
	public void create(Brand entity) {
		dao.save(entity);
	}
	@Override
	public void update(Brand entity) {
		dao.save(entity);
	}
	
	@Override
	public void delete(Integer id) {
		dao.deleteById(id);
	}

}
