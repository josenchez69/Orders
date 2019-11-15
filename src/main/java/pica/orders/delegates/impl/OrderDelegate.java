package com.TouresBalon.Orders.delegate.impl;

import com.TouresBalon.Orders.delegate.IOrderDelegate;
import com.TouresBalon.Orders.dto.RequestApiDto;
import com.TouresBalon.Orders.dto.OrderDto;
import com.TouresBalon.Orders.service.IOrderService;
import com.TouresBalon.Orders.exception.OrderException;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class OrderDelegate implements IOrderDelegate {
    @Autowired
    private IOrderService iOrderService;

    @Override
    public OrderDto createOrder(RequestApiDto<OrderDto> requestApiDto) throws OrderException {
        return iOrderService.createOrder(requestApiDto.getData());
    }

    @Override
    public List<OrderDto> listOrders(long customerid) throws OrderException {
        return iOrderService.listOrders(customerid);
    }
}
