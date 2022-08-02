package dtn.asm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dtn.asm.entity.Color;

public interface ColorDAO extends JpaRepository<Color, Integer> {

}
