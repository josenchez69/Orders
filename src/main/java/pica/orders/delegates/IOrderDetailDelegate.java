package com.TouresBalon.Orders.delegate;

import com.TouresBalon.Orders.dto.OrderDetailDto;
import com.TouresBalon.Orders.dto.RequestApiDto;
import com.TouresBalon.Orders.exception.OrderException;

import java.util.List;

public interface IOrderDetailDelegate {
    OrderDetailDto createOrderDetail(RequestApiDto<OrderDetailDto> requestApiDto) throws OrderException;
    List<OrderDetailDto> listOrders(long orderid) throws OrderException;
}
