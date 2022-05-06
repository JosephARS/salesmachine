package com.globant.sewingmachines.inventory.repository;

import com.globant.sewingmachines.inventory.models.entity.MachineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MachineRepository extends JpaRepository<MachineEntity, Long>{
}
