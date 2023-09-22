package com.springApplication.SalesPOS.dto.request;

import com.springApplication.SalesPOS.entity.Item;
import com.springApplication.SalesPOS.entity.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailSaveRequestDTO {
    private String itemName;
    private double qty;
    private double amount;
    private int item;
}
