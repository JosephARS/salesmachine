package com.globant.sewingmachines.purchase.models.endpoints;

import com.globant.sewingmachines.purchase.models.dto.CheckListDTO;
import lombok.Builder;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Builder
public class NewPurchaseRequest {

    @NotEmpty(message = "El campo 'brand' no puede ser nulo.")
    String brand;
    @NotEmpty(message = "El campo 'model' no puede ser nulo.")
    String model;
    @NotEmpty(message = "El campo 'serial' no puede ser nulo.")
    String serial;
    @NotNull(message = "El campo 'location' no puede ser nulo.")
    Long location;
    @NotNull(message = "El campo 'price' no puede ser nulo.")
    Long price;
    @NotNull(message = "El campo 'userPurchase' no puede ser nulo.")
    Long userPurchase;

    @Valid
    CheckListDTO checkList;

}
