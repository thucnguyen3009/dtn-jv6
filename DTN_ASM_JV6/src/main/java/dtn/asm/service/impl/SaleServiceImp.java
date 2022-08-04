package dtn.asm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dtn.asm.dao.SaleDAO;
import dtn.asm.entity.Sale;
import dtn.asm.service.SaleService;
@Service
public class SaleServiceImp implements SaleService {

	@Autowired
	SaleDAO dao;
	
	@Override
	public List<Sale> findAll() {
		return dao.findAll();
	}
	@Override
	public Sale findById(Integer id) {
		return dao.getById(id);
	}
	
	@Override
	public void create(Sale entity) {
		dao.save(entity);
	}
	@Override
	public void update(Sale entity) {
		dao.save(entity);
	}
	@Override
	public void delete(Integer id) {
		dao.deleteById(id);
	}

}
