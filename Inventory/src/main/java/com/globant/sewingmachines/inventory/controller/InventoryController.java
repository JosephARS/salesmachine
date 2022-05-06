package com.globant.sewingmachines.inventory.controller;

import com.globant.sewingmachines.inventory.models.entity.MachineEntity;
import com.globant.sewingmachines.inventory.models.request.CreateMachineRequest;
import com.globant.sewingmachines.inventory.models.response.CreateMachineResponse;
import com.globant.sewingmachines.inventory.models.response.InventoryResponse;
import com.globant.sewingmachines.inventory.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private MachineService machineService;

    /*Creacion de nuevas maquinas*/
    @RequestMapping(value = "/addMachine", method = RequestMethod.POST)
    public ResponseEntity<?> createNewMachine(@RequestBody CreateMachineRequest request){
        try{
            machineService.createMachine(request);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>( HttpStatus.CREATED);
    }
    @RequestMapping(value = "/getAllInventary", method = RequestMethod.GET)
    public ResponseEntity<?> getAllInventary(){
        List<InventoryResponse> lista = machineService.getAllMachine();

        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

}
