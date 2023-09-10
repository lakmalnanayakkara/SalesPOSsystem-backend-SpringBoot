package com.springApplication.SalesPOS.entity;

import com.springApplication.SalesPOS.entity.enums.MeasuringUnitType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "item")
@AllArgsConstructor
@NoArgsConstructor
/*@Setter
@Getter
@ToString*/
@Data
public class Item {
    @Id
    @Column(name = "item_id", length = 100)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemID;

    @Column(name = "item_name",length = 50, nullable = false)
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name = "unit_type", length = 10, nullable = false)
    private MeasuringUnitType measuringUnitType;

    @Column(name = "balance_qty", length = 100, nullable = false)
    private double balanceQty;

    @Column(name = "supplier_price")
    private double supplierPrice;

    @Column(name = "seller_price")
    private double sellerPrice;

    @Column(name = "active_state", columnDefinition = "TINYINT default 0")
    private boolean activeState;
}
