package com.springApplication.SalesPOS.service;

import com.springApplication.SalesPOS.dto.CustomerDTO;
import com.springApplication.SalesPOS.dto.request.CustomerUpdateDTO;

import java.util.List;

public interface CustomerService {
    public String CustomerSave(CustomerDTO customerDTO);

    public String CustomerUpdate(CustomerUpdateDTO customerUpdateDTO);

    public CustomerDTO getCustomerById(int customerID);

    public String CustomerDelete(int customerID);

    public List<CustomerDTO> getAllCustomers();

    List<CustomerDTO> getAllCustomersByActiveState(boolean activeState);
}
