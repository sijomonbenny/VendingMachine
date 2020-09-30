package com.baton.vm.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.baton.vm.model.Inventory;

public interface VendingMachineRepository extends JpaRepository<Inventory, Integer> {

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update Inventory inv set inv.quantity = inv.quantity - 1 where inv.inventoryId =:invId")
	void updateStock(@Param("invId") Integer inid);
}
