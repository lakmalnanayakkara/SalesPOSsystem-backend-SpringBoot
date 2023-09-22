package com.springApplication.SalesPOS.service;

import com.springApplication.SalesPOS.dto.request.OrderSaveRequestDTO;

public interface OrderService {
    String addOrders(OrderSaveRequestDTO orderSaveRequestDTO);
}
