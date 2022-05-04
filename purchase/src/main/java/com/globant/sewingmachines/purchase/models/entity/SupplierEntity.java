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
@Table(name="Supplier")
public class SupplierEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idSupplier;

    String name;

    @Column(nullable = false, unique = true)
    String nit;

    String address;

    Boolean active;

}