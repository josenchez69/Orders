package com.TouresBalon.Orders.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name="Orders")
public class Order {
    @Id
    private Long OrderId;
    private Long CustomerId;
    private String OrderDate;
    private Double Price;
    private String Status;
    private String Comments;

    public Order() {

    }
}
