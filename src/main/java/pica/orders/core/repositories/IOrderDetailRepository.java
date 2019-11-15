package com.TouresBalon.Orders.repository;

import com.TouresBalon.Orders.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}
