package dtn.asm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dtn.asm.entity.Color;
import dtn.asm.entity.ProductColor;

public interface ProductColorDAO extends JpaRepository<ProductColor, Integer> {

	List<ProductColor> findByColor(Color color);
	
}
