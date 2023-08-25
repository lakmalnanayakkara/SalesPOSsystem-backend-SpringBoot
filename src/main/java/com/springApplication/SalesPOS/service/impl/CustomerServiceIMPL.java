package com.springApplication.SalesPOS.service.impl;

import com.springApplication.SalesPOS.dto.CustomerDTO;
import com.springApplication.SalesPOS.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceIMPL implements CustomerService {
    @Override
    public String CustomerSave(CustomerDTO customerDTO) {
        System.out.println(customerDTO.getCustomerName());
        return customerDTO.getCustomerName();
    }
}


