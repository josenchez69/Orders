package com.TouresBalon.Orders.service;

import com.TouresBalon.Orders.dto.OrderDto;
import com.TouresBalon.Orders.exception.OrderException;

import java.util.List;

public interface IOrderService {
    OrderDto createOrder(OrderDto orderDto) throws OrderException;
    List<OrderDto> listOrders(long customerid) throws OrderException;
}
