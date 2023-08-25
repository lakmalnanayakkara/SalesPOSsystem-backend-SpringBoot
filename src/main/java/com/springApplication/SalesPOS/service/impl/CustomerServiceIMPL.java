package com.springApplication.SalesPOS.service.impl;

import com.springApplication.SalesPOS.dto.CustomerDTO;
import com.springApplication.SalesPOS.entity.Customer;
import com.springApplication.SalesPOS.repo.CustomerRepo;
import com.springApplication.SalesPOS.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceIMPL implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;
    @Override
    public String CustomerSave(CustomerDTO customerDTO) {
        Customer customer = new Customer(
                customerDTO.getCustomerID(),
                customerDTO.getCustomerName(),
                customerDTO.getCustomerAddress(),
                customerDTO.getCustomerSalary(),
                customerDTO.getContactNumber(),
                customerDTO.getCustomerNIC(),
                customerDTO.isState()
        );
        customerRepo.save(customer);
        return customerDTO.getCustomerName();
    }
}


