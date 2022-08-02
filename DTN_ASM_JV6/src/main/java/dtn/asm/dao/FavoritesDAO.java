package dtn.asm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dtn.asm.entity.Favorites;

public interface FavoritesDAO extends JpaRepository<Favorites, Integer> {

}
