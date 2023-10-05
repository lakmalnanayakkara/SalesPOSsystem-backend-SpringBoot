package com.springApplication.SalesPOS.dto.queryinterface;

import java.util.Date;

public interface OrderdetailInterface {
    String getCustomerName();
    String getCustomerAddress();
    String getContactNumber();
    Date getDate();
    double getTotAmount();
}
