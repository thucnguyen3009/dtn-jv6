package dtn.asm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dtn.asm.entity.Categories;

public interface CategoriesDAO extends JpaRepository<Categories, Integer> {

}
