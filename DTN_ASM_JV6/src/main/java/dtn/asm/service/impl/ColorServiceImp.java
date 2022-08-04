package dtn.asm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dtn.asm.dao.ColorDAO;
import dtn.asm.entity.Color;
import dtn.asm.service.ColorService;
@Service
public class ColorServiceImp implements ColorService {

	@Autowired
	ColorDAO dao;
	
	@Override
	public List<Color> findAll() {
		return dao.findAll();
	}
	@Override
	public Color findById(Integer id) {
		return dao.getById(id);
	}
	@Override
	public void create(Color entity) {
		dao.save(entity);
	}
	@Override
	public void update(Color entity) {
		dao.save(entity);
	}
	@Override
	public void delete(Integer id) {
		dao.deleteById(id);
	}
}
