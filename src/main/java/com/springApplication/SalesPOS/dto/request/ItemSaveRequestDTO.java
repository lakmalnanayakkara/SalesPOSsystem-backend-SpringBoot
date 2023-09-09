package com.springApplication.SalesPOS.dto.request;

import com.springApplication.SalesPOS.entity.enums.MeasuringUnitType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemSaveRequestDTO {

    private int ItemID;
    private String ItemName;
    private MeasuringUnitType measuringUnitTYpe;
    private double BalanceQty;
    private double SupplierPrice;
    private double SellingPrice;

}
