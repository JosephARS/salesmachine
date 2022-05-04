package com.globant.sewingmachines.purchase.repository;

import com.globant.sewingmachines.purchase.models.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<SupplierEntity, Long> {



}
