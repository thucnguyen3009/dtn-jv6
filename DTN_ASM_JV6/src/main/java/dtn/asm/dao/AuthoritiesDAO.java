package dtn.asm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dtn.asm.entity.Authorities;


public interface AuthoritiesDAO extends JpaRepository<Authorities, Integer> {

}
