package com.springApplication.SalesPOS.dto.response;

import com.springApplication.SalesPOS.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemGetResponseDTO {
    private int itemID;
    private String itemName;
    private MeasuringUnitType measuringUnitType;
    private double balanceQty;
    private double supplierPrice;
    private double sellerPrice;
    private boolean activeState;
}
