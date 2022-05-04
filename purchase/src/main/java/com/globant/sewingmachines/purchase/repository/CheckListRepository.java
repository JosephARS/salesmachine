package com.globant.sewingmachines.purchase.repository;

import com.globant.sewingmachines.purchase.models.entity.CheckListEntity;
import com.globant.sewingmachines.purchase.models.entity.PurchaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckListRepository extends JpaRepository<CheckListEntity, Long> {

    CheckListEntity findByPurchase(PurchaseEntity purchase);

}
