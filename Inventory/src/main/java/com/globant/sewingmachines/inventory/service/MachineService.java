package com.globant.sewingmachines.inventory.service;

import com.globant.sewingmachines.inventory.models.entity.MachineEntity;
import com.globant.sewingmachines.inventory.models.request.CreateMachineRequest;
import com.globant.sewingmachines.inventory.models.response.CreateMachineResponse;
import com.globant.sewingmachines.inventory.models.response.InventoryResponse;

import java.util.List;

public interface MachineService {

    CreateMachineResponse createMachine(CreateMachineRequest createMachineRequest);
    List<InventoryResponse> getAllMachine();
}
