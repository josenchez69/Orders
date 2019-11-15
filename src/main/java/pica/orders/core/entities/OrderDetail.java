package com.TouresBalon.Orders.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="Items")
public class OrderDetail {
    @Id
    private Long OrderDetailId;
    private Long OrderId;
    private Long ProductId;
    private String ProductName;
    private Double Price;
    private int Quantity;

    public OrderDetail() {

    }
}
