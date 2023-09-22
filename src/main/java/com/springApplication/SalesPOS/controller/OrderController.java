package com.springApplication.SalesPOS.controller;

import com.springApplication.SalesPOS.dto.request.OrderSaveRequestDTO;
import com.springApplication.SalesPOS.service.OrderService;
import com.springApplication.SalesPOS.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/orders")
@CrossOrigin
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> orderSave(@RequestBody OrderSaveRequestDTO orderSaveRequestDTO){
        String message = orderService.addOrders(orderSaveRequestDTO);
        ResponseEntity<StandardResponse> response = new ResponseEntity<>(
                new StandardResponse(200, "success", message),
                HttpStatus.OK
        );
        return response;
    }
}
