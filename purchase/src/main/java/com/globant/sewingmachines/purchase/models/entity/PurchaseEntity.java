package com.globant.sewingmachines.purchase.models.entity;

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
@Table(name="Purchase",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"serial", "creationDate"})
)
public class PurchaseEntity implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idPurchase;

    String brand;
    String model;
    @Column(name = "serial",nullable = false, unique = true)
    String serial;
    Long location;
    Long price;
    @Temporal(TemporalType.DATE)
    @Column(name = "creationDate", nullable = false)
    Date creationDate;
    Long userPurchase;

}
