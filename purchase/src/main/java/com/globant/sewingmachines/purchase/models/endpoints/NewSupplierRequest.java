package com.globant.sewingmachines.purchase.models.endpoints;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
public class NewSupplierRequest {

    @NotEmpty(message = "El campo 'name' no puede ser nulo.")
    String name;

    @NotEmpty(message = "El campo 'nit' no puede ser nulo.")
    String nit;

    @NotEmpty(message = "El campo 'address' no puede ser nulo.")
    String address;

}
