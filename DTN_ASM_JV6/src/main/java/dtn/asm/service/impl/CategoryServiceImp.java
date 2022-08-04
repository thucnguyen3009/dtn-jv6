package dtn.asm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dtn.asm.dao.CategoriesDAO;
import dtn.asm.entity.Categories;
import dtn.asm.service.CategoriesService;

@Service
public class CategoryServiceImp implements CategoriesService {

	@Autowired
	CategoriesDAO dao;
	
	@Override
	public List<Categories> findAll() {
		return dao.findAll();
	}
	
	@Override
	public Categories findById(Integer id) {
		return dao.findById(id).get();
	}
	
	@Override
	public void create(Categories entity) {
		dao.save(entity);
	}
	
	@Override
	public void update(Categories entity) {
		dao.save(entity);
	}
	
	@Override
	public void delete(Integer id) {
		dao.deleteById(id);
	}

}
