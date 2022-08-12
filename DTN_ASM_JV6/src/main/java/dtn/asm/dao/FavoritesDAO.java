package dtn.asm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dtn.asm.entity.Accounts;
import dtn.asm.entity.Favorites;
import dtn.asm.entity.Products;

public interface FavoritesDAO extends JpaRepository<Favorites, Integer> {

	List<Favorites> findByProductsId(Products productsId);
	
	List<Favorites> findByUserFvr(Accounts userFvr);
}
