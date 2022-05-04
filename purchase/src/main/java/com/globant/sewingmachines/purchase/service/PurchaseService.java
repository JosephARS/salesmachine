package com.globant.sewingmachines.purchase.service;

import com.globant.sewingmachines.purchase.models.endpoints.NewPurchaseRequest;
import com.globant.sewingmachines.purchase.models.endpoints.NewSupplierRequest;
import com.globant.sewingmachines.purchase.models.endpoints.PurchaseDetailsResponse;

import java.util.List;

public interface PurchaseService {

    Object createNewPurchase(NewPurchaseRequest request);
    List<PurchaseDetailsResponse> getPurchaseList();
    Object createNewSupplier(NewSupplierRequest request);

}
