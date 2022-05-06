package com.globant.sewingmachines.inventory.models.request;

import lombok.Data;

import java.util.Date;

@Data
public class CreateMachineRequest {
    String machineBrand;
    String machineModel;
    String location;
    String purchasePrice;
    String purchaseReceipt;
    Date creationDate;
    Date saleDate;
    String vendor;
    String state;
}
