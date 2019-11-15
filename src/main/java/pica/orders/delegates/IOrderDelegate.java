package com.TouresBalon.Orders.delegate;

import com.TouresBalon.Orders.dto.RequestApiDto;
import com.TouresBalon.Orders.dto.OrderDto;
import com.TouresBalon.Orders.exception.OrderException;

import java.util.List;

public interface IOrderDelegate {
    OrderDto createOrder(RequestApiDto<OrderDto> requestApiDto) throws OrderException;
    List<OrderDto> listOrders(long customerid) throws OrderException;
}
