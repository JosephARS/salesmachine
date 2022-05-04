package com.globant.sewingmachines.purchase.controller;

import com.globant.sewingmachines.purchase.models.endpoints.NewPurchaseRequest;
import com.globant.sewingmachines.purchase.models.endpoints.NewSupplierRequest;
import com.globant.sewingmachines.purchase.service.PurchaseService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/purchase")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class PurchaseController {

    PurchaseService purchaseService;

    @PostMapping(path = "/")
    public ResponseEntity createNewPurchase(@Valid @RequestBody NewPurchaseRequest request){
        log.info(request.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(purchaseService.createNewPurchase(request));
    }

    @GetMapping(path = "/")
    public ResponseEntity getPurchaseList(){
        return ResponseEntity.status(HttpStatus.CREATED).body(purchaseService.getPurchaseList());
    }

    @PostMapping(path = "/supplier/")
    public ResponseEntity createNewSupplier(@Valid @RequestBody NewSupplierRequest request){
        log.info(request.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(purchaseService.createNewSupplier(request));
    }



    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
