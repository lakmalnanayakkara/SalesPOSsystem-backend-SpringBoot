package com.springApplication.SalesPOS.controller;

import com.springApplication.SalesPOS.dto.CustomerDTO;
import com.springApplication.SalesPOS.dto.request.CustomerUpdateDTO;
import com.springApplication.SalesPOS.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PutMapping("/update")
    public String customerUpdate(@RequestBody CustomerUpdateDTO customerUpdateDTO){
        String message = customerService.CustomerUpdate(customerUpdateDTO);
        return message;
    }
    @GetMapping(
            path = "/getById",
            params = "id"
    )
    public CustomerDTO getCustomerById(@RequestParam(value = "id") int customerID){
        CustomerDTO customerDTO = customerService.getCustomerById(customerID);
        return customerDTO;
    }
    @DeleteMapping(
            path = "/delete/{id}"
    )
    public String customerDelete(@PathVariable(value = "id") int customerID){
        String message = customerService.CustomerDelete(customerID);
        return message;
    }
    @GetMapping(path = "/get-all-customers")
    public List<CustomerDTO> getAllCustomers(){
        List<CustomerDTO> AllCustomers = customerService.getAllCustomers();
        return AllCustomers;
    }
    @GetMapping(path="/get-all-customers-active-state/{state}")
    public List<CustomerDTO> getAllCustomersByActiveState(@PathVariable(value = "state") boolean activeState){
        List<CustomerDTO> AllCustomers = customerService.getAllCustomersByActiveState(activeState);
        return AllCustomers;
    }
}
