package com.globant.sewingmachines.purchase.models.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="CheckList")
public class CheckListEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCheckList;

    Boolean working;

    String structure;

    String comments;

    String status;

    @ManyToOne(optional = false) //@JoinColumn(name = "idPurchase")
    PurchaseEntity purchase;

}
