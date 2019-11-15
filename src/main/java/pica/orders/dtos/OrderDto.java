package com.TouresBalon.Orders.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class OrderDto {
    private Long orderId;
    private Long customerId;
    private String orderDate;
    private Double price;
    private String status;
    private String comments;
}
