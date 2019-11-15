package com.TouresBalon.Orders.service;

import com.TouresBalon.Orders.dto.OrderDetailDto;
import com.TouresBalon.Orders.exception.OrderException;

import java.util.List;

public interface IOrderDetailService {
    OrderDetailDto createOrderDetail(OrderDetailDto orderdetailDto) throws OrderException;
    List<OrderDetailDto> listOrders(long orderid) throws OrderException;
}
