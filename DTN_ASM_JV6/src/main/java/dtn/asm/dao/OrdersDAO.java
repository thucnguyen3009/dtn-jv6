package dtn.asm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
<<<<<<< HEAD
=======
import org.springframework.data.repository.query.Param;
>>>>>>> f50877d78bacce93d8a801611b489358f9cf23d0

import dtn.asm.entity.Accounts;
import dtn.asm.entity.Orders;
import dtn.asm.entity.Sale;

public interface OrdersDAO extends JpaRepository<Orders, Integer> {

	List<Orders> findBySaleId(Sale saleId);
	
<<<<<<< HEAD
	List<Orders> findByUserOrder(Accounts userOrder);
	
	@Query(value = "SELECT * FROM Orders WHERE statusid = ?",nativeQuery = true)
	List<Orders> findAllById2(Integer id);
	
	@Query("SELECT count(o) FROM Orders o WHERE o.statusId.id = 3")
	Integer getCount();
=======
	@Query (value="select * from Orders a where a.username=?1", nativeQuery = true)
	List<Orders> find_LoginbyUsername(String username);
	
>>>>>>> f50877d78bacce93d8a801611b489358f9cf23d0
}
