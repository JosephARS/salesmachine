package com.globant.sewingmachines.sales.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globant.sewingmachines.sales.entity.SalesInventory;

@Repository
public interface InventoryRepository extends JpaRepository<SalesInventory, Integer>{
	SalesInventory findById(int id);
}
