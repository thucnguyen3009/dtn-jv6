package dtn.asm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dtn.asm.entity.Sale;

public interface SaleDAO extends JpaRepository<Sale, Integer> {


}
