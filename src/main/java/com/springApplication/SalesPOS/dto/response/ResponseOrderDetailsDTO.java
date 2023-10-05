package com.springApplication.SalesPOS.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseOrderDetailsDTO {
    //From Customer Table
    private String customerName;
    private String customerAddress;
    private String contactNumber;

    //From Order Table
    private Date date;
    private double totAmount;
}
