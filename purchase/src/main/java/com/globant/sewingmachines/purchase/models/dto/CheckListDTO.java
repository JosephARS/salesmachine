package com.globant.sewingmachines.purchase.models.dto;

import lombok.Builder;
import lombok.Data;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class CheckListDTO {

    @NotEmpty(message = "El campo 'status' no puede ser nulo.")
    String status;

    @NotNull(message = "El campo 'working' no puede ser nulo.")
    Boolean working;

    @NotEmpty(message = "El campo 'structure' no puede ser nulo.")
    String structure;

    @NotEmpty(message = "El campo 'comments' no puede ser nulo.")
    String comments;

}
