package dtn.asm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dtn.asm.entity.Brand;

public interface BrandDAO extends JpaRepository<Brand, Integer> {

}
