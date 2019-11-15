package com.TouresBalon.Orders.repository;

import com.TouresBalon.Orders.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Order, Long> {
}
