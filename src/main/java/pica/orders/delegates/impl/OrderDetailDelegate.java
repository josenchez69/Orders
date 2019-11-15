package com.TouresBalon.Orders.delegate.impl;

import com.TouresBalon.Orders.delegate.IOrderDetailDelegate;
import com.TouresBalon.Orders.dto.OrderDetailDto;
import com.TouresBalon.Orders.dto.RequestApiDto;
import com.TouresBalon.Orders.service.IOrderDetailService;
import com.TouresBalon.Orders.exception.OrderException;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class OrderDetailDelegate implements IOrderDetailDelegate {
    @Autowired
    private IOrderDetailService iOrderDetailService;

    @Override
    public OrderDetailDto createOrderDetail(RequestApiDto<OrderDetailDto> requestApiDto) throws OrderException {
        return iOrderDetailService.createOrderDetail(requestApiDto.getData());
    }

    @Override
    public List<OrderDetailDto> listOrders(long orderid) throws OrderException {
        return iOrderDetailService.listOrders(orderid);
    }
}
