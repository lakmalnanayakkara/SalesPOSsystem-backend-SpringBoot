package com.springApplication.SalesPOS.service;

import com.springApplication.SalesPOS.dto.paginated.PaginatedResponseItemDTO;
import com.springApplication.SalesPOS.dto.paginated.PaginatedResponseOrderDTO;
import com.springApplication.SalesPOS.dto.request.OrderSaveRequestDTO;

public interface OrderService {
    String addOrders(OrderSaveRequestDTO orderSaveRequestDTO);

    PaginatedResponseOrderDTO getAllOrderDetails(boolean status, int page, int size);
}
