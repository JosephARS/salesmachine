package com.globant.sewingmachines.purchase.models.endpoints;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.globant.sewingmachines.purchase.models.dto.CheckListDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@JsonIgnoreProperties
public class PurchaseDetailsResponse {

    Long idPurchase;

    String brand;

    String model;

    String serial;

    Long location;

    Long price;

    Long userPurchase;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    CheckListDTO checkList;

}
