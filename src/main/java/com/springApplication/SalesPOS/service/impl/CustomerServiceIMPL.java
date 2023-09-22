package com.springApplication.SalesPOS.service.impl;

import com.springApplication.SalesPOS.dto.CustomerDTO;
import com.springApplication.SalesPOS.dto.request.CustomerUpdateDTO;
import com.springApplication.SalesPOS.entity.Customer;
import com.springApplication.SalesPOS.exception.NotFoundException;
import com.springApplication.SalesPOS.repo.CustomerRepo;
import com.springApplication.SalesPOS.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public String CustomerUpdate(CustomerUpdateDTO customerUpdateDTO) {
        if(customerRepo.existsById(customerUpdateDTO.getCustomerID())){
            Customer customer = customerRepo.getReferenceById(customerUpdateDTO.getCustomerID());

            customer.setCustomerName(customerUpdateDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
            customer.setCustomerSalary(customerUpdateDTO.getCustomerSalary());

            customerRepo.save(customer);

            return customerUpdateDTO.getCustomerName() + " Name Updated.";
        }else {
            throw new RuntimeException("No Data Found");
        }
    }

    @Override
    public CustomerDTO getCustomerById(int customerID) {
        if(customerRepo.existsById(customerID)){
            Customer customer = customerRepo.getReferenceById(customerID);
            CustomerDTO customerDTO= new CustomerDTO(
                    customer.getCustomerID(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerSalary(),
                    customer.getContactNumber(),
                    customer.getCustomerNIC(),
                    customer.isState()
            );
            return customerDTO;
        }else {
            throw new RuntimeException("No Such a customer.");
        }
    }

    @Override
    public String CustomerDelete(int customerID) {
        if(customerRepo.existsById(customerID)){
            customerRepo.deleteById(customerID);
            return "Customer Deleted";
        }else{
            throw new RuntimeException("Customer Not Exists.");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> getAllCustomers = customerRepo.findAll();
        List<CustomerDTO> customerDTOlist = new ArrayList<>();
        if(getAllCustomers.size()>0){
            for(Customer customer : getAllCustomers){
                CustomerDTO customerDTO = new CustomerDTO(
                        customer.getCustomerID(),
                        customer.getCustomerName(),
                        customer.getCustomerAddress(),
                        customer.getCustomerSalary(),
                        customer.getContactNumber(),
                        customer.getCustomerNIC(),
                        customer.isState()
                );
                customerDTOlist.add(customerDTO);
            }
        }else {
            throw new NotFoundException("No Customer Found");
        }
        return customerDTOlist;
    }

    @Override
    public List<CustomerDTO> getAllCustomersByActiveState(boolean activeState) {
        List<Customer> getAllCustomers = customerRepo.findAllByStateEquals(activeState);
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        for(Customer customer : getAllCustomers){
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerID(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerSalary(),
                    customer.getContactNumber(),
                    customer.getCustomerNIC(),
                    customer.isState()
            );
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }

}


