package com.springApplication.SalesPOS.entity;

import com.springApplication.SalesPOS.entity.enums.MeasuringUnitType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="item")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Item {
    @Id
    @Column(name = "item_id", length = 20)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ItemID;

    @Column(name = "item_name",length = 20, nullable = false)
    private String ItemName;

    @Column(name = "unit_type", length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private MeasuringUnitType measuringUnitTYpe;

    @Column(name = "balance_qty", length = 20, nullable = false)
    private double BalanceQty;

    @Column(name = "supplier_price", length = 20, nullable = false)
    private double SupplierPrice;

    @Column(name = "selling_price", length = 20, nullable = false)
    private double SellingPrice;

    @Column(name = "state", columnDefinition = "TINYINT default 0")
    private boolean ActiveState;
}
