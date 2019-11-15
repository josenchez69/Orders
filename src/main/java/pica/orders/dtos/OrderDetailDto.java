package com.TouresBalon.Orders.dto;

import lombok.Data;

@Data
public class OrderDetailDto {
    private Long OrderDetailId;
    private Long orderId;
    private Long ProductId;
    private String ProductName;
    private Double price;
    private int Quantity;
}
