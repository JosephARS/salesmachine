package com.globant.sewingmachines.purchase.service;

import com.globant.sewingmachines.purchase.models.dto.CheckListDTO;
import com.globant.sewingmachines.purchase.models.endpoints.NewPurchaseRequest;
import com.globant.sewingmachines.purchase.models.endpoints.NewSupplierRequest;
import com.globant.sewingmachines.purchase.models.endpoints.PurchaseDetailsResponse;
import com.globant.sewingmachines.purchase.models.entity.CheckListEntity;
import com.globant.sewingmachines.purchase.models.entity.PurchaseEntity;
import com.globant.sewingmachines.purchase.models.entity.SupplierEntity;
import com.globant.sewingmachines.purchase.repository.CheckListRepository;
import com.globant.sewingmachines.purchase.repository.PurchaseRepository;
import com.globant.sewingmachines.purchase.repository.SupplierRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.*;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class PurchaseServiceImpl implements PurchaseService {

    PurchaseRepository purchaseRepository;
    CheckListRepository checkListRepository;
    SupplierRepository supplierRepository;

    @Override @Transactional
    public Object createNewPurchase(NewPurchaseRequest request) {

        try {
            PurchaseEntity purchase = purchaseRepository.save(PurchaseEntity.builder()
                    .brand(request.getBrand())
                    .creationDate(new Date())
                    .userPurchase(request.getUserPurchase())
                    .location(request.getLocation())
                    .model(request.getModel())
                    .price(request.getPrice())
                    .serial(request.getSerial())
                    .userPurchase(request.getUserPurchase())
                    .build());

            checkListRepository.save(CheckListEntity.builder()
                    .comments(request.getCheckList().getComments())
                    .purchase(purchase)
                    .status(request.getCheckList().getStatus())
                    .structure(request.getCheckList().getStructure())
                    .working(request.getCheckList().getWorking())
                    .build());

            return PurchaseDetailsResponse.builder()
                    .idPurchase(purchase.getIdPurchase())
                    .brand(purchase.getBrand())
                    .location(purchase.getLocation())
                    .model(purchase.getModel())
                    .userPurchase(purchase.getUserPurchase())
                    .price(purchase.getPrice())
                    .serial(purchase.getSerial())
                    .build();
        } catch (HttpStatusCodeException e) {
            Map<String, String> errors = new HashMap<>();
            errors.put("message", e.getMessage());
            errors.put("body", e.getResponseBodyAsString());
            errors.put("code", e.getStatusCode().toString());
            return errors;
        } catch (Exception e) {
            Map<String, String> errors = new HashMap<>();
            errors.put("message", e.getMessage());
            return errors;
        }

    }

    @Override
    public List<PurchaseDetailsResponse> getPurchaseList() {

        List<PurchaseDetailsResponse> detailsResponseList = new ArrayList<>();

        List<PurchaseEntity> purchaseList = purchaseRepository.findAll();

        purchaseList.forEach( purchase -> {

            Optional<CheckListEntity> checkList = Optional.of(new CheckListEntity());
            checkList = Optional.ofNullable(checkListRepository.findByPurchase(purchase));

            detailsResponseList.add(PurchaseDetailsResponse.builder()
                            .idPurchase(purchase.getIdPurchase())
                            .serial(purchase.getSerial())
                            .price(purchase.getPrice())
                            .userPurchase(purchase.getUserPurchase())
                            .model(purchase.getModel())
                            .location(purchase.getLocation())
                            .brand(purchase.getBrand())
                            .checkList(CheckListDTO.builder().comments(checkList.get().getComments())
                                    .status(checkList.get().getStatus())
                                    .structure(checkList.get().getStructure())
                                    .working(checkList.get().getWorking())
                                    .build())
                    .build());
            });

        return detailsResponseList;
    }

    @Override
    public Object createNewSupplier(NewSupplierRequest request) {

        try {
            SupplierEntity supplier = supplierRepository.save(SupplierEntity.builder()
                            .address(request.getAddress())
                            .name(request.getName())
                            .nit(request.getNit())
                            .active(true)
                    .build());


            return supplier;

        } catch (HttpStatusCodeException e) {
            Map<String, String> errors = new HashMap<>();
            errors.put("message", e.getMessage());
            errors.put("body", e.getResponseBodyAsString());
            errors.put("code", e.getStatusCode().toString());
            return errors;
        } catch (Exception e) {
            Map<String, String> errors = new HashMap<>();
            errors.put("message", e.getMessage());
            return errors;
        }
    }
}
