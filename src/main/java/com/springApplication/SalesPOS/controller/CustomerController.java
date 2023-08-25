package com.springApplication.SalesPOS.controller;

import com.springApplication.SalesPOS.dto.CustomerDTO;
import com.springApplication.SalesPOS.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public String customerSave(@RequestBody CustomerDTO customerDTO){
        customerService.CustomerSave(customerDTO);
        return "Saved";
    }
}
