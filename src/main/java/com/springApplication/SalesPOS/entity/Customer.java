package com.springApplication.SalesPOS.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="customer")
public class Customer {
    @Id
    @Column(name="customer_id", length=20)
    private int customerID;
    @Column(name="customer_name", length=50, nullable = false)
    private String customerName;
    @Column(name="customer_address", length=50)
    private String customerAddress;
    @Column(name="customer_salary")
    private double customerSalary;
    @Column(name="contact_number", length = 10)
    private String contactNumber;
    @Column(name="customer_nic")
    private String customerNIC;
    @Column(name="active_state", columnDefinition ="TINYINT default 0")
    private boolean state;

    public Customer() {
    }

    public Customer(int customerID, String customerName, String customerAddress, double customerSalary, String contactNumber, String customerNIC, boolean state) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerSalary = customerSalary;
        this.contactNumber = contactNumber;
        this.customerNIC = customerNIC;
        this.state = state;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public double getCustomerSalary() {
        return customerSalary;
    }

    public void setCustomerSalary(double customerSalary) {
        this.customerSalary = customerSalary;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getCustomerNIC() {
        return customerNIC;
    }

    public void setCustomerNIC(String customerNIC) {
        this.customerNIC = customerNIC;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
