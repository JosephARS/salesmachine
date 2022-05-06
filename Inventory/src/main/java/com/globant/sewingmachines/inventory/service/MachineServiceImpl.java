package com.globant.sewingmachines.inventory.service;

import com.globant.sewingmachines.inventory.models.request.CreateMachineRequest;
import com.globant.sewingmachines.inventory.models.response.CreateMachineResponse;
import com.globant.sewingmachines.inventory.models.entity.MachineEntity;
import com.globant.sewingmachines.inventory.models.response.InventoryResponse;
import com.globant.sewingmachines.inventory.repository.MachineRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class MachineServiceImpl implements MachineService{

    @Autowired
    MachineRepository machineRepository;

    @Override
    public CreateMachineResponse createMachine(CreateMachineRequest request) {
        MachineEntity machine = machineRepository.save(MachineEntity.builder()
                .machineBrand(request.getMachineBrand())
                .machineModel(request.getMachineModel())
                .creationDate(new Date())
                .location(request.getLocation())
                .purchasePrice(request.getPurchasePrice())
                .purchaseReceipt(request.getPurchaseReceipt())
                .saleDate(new Date())
                .state(request.getState())
                .vendor(request.getVendor())
                .purchasePrice(request.getPurchasePrice())
                .build());
        return CreateMachineResponse.builder()
                .machineBrand(machine.getMachineBrand())
                .machineModel(machine.getMachineModel())
                .creationDate(machine.getCreationDate())
                .location(machine.getLocation())
                .purchasePrice(machine.getPurchasePrice())
                .purchaseReceipt(machine.getPurchaseReceipt())
                .saleDate(machine.getSaleDate())
                .state(machine.getState())
                .vendor(machine.getVendor())
                .purchasePrice(machine.getPurchasePrice())
                .build();
    }

    public List<InventoryResponse> getAllMachine() {
        List<InventoryResponse> inventoryResponseList = new ArrayList<>();
        List<MachineEntity> machineEntityList =  machineRepository.findAll();
        for(MachineEntity a: machineEntityList){
            inventoryResponseList.add(InventoryResponse.builder()
                .idMachine(a.getIdMachine())
                .machineBrand(a.getMachineBrand())
                .machineModel(a.getMachineModel())
                .creationDate(a.getCreationDate())
                .location(a.getLocation())
                .purchasePrice(a.getPurchasePrice())
                .purchaseReceipt(a.getPurchaseReceipt())
                .saleDate(a.getSaleDate())
                .state(a.getState())
                .vendor(a.getVendor())
                .purchasePrice(a.getPurchasePrice())
                .build());
        }
        return inventoryResponseList;
    }
}
