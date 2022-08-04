package dtn.asm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dtn.asm.dao.ProductsDAO;
import dtn.asm.entity.Products;
import dtn.asm.service.ProductsService;
@Service
public class ProductsServiceImp implements ProductsService{

	@Autowired
	ProductsDAO dao;
	
	@Override
	public List<Products> findAll() {
		return dao.findAll();
	}
	@Override
	public Products findById(Integer id) {
		return dao.getById(id);
	}
	@Override
	public void create(Products entity) {
		dao.save(entity);
	}
	@Override
	public void update(Products entity) {
		dao.save(entity);
	}
	@Override
	public void delete(Integer id) {
		dao.deleteById(id);
	}

}
