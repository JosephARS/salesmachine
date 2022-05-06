package com.globant.sewingmachines.inventory.models.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Inventory")
public class MachineEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idMachine;
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
