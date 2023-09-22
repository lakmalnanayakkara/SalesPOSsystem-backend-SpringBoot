package com.springApplication.SalesPOS.dto.request;

import com.springApplication.SalesPOS.entity.Customer;
import com.springApplication.SalesPOS.entity.OrderDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderSaveRequestDTO {
    private int customer;
    private Date date;
    private double totAmount;
    private List<OrderDetailSaveRequestDTO> orderDetailSaveRequestDTOList;
}
