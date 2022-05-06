package com.globant.sewingmachines.inventory.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@JsonIgnoreProperties
public class CreateMachineResponse {
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
