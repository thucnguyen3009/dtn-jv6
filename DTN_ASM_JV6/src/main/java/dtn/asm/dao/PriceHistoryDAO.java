package dtn.asm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dtn.asm.entity.PriceHistory;

public interface PriceHistoryDAO extends JpaRepository<PriceHistory, Integer> {

}
