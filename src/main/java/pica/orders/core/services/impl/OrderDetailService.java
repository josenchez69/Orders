package com.TouresBalon.Orders.service.impl;

import com.TouresBalon.Orders.constant.MessageCauseException;
import com.TouresBalon.Orders.dto.OrderDetailDto;
import com.TouresBalon.Orders.entity.OrderDetail;
import com.TouresBalon.Orders.exception.OrderException;
import com.TouresBalon.Orders.repository.IOrderDetailRepository;
import com.TouresBalon.Orders.service.IOrderDetailService;
import com.TouresBalon.Orders.exception.OrderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDetailService implements IOrderDetailService {
    @Autowired
    private IOrderDetailRepository iOrderRepository;

    @Override
    public OrderDetailDto createOrderDetail(OrderDetailDto orderDto) throws OrderException {
        try {
            OrderDetail order = new OrderDetail();
            order.setOrderId(orderDto.getOrderId());
            order.setOrderDetailId(orderDto.getOrderDetailId());
            order.setProductId(orderDto.getProductId());
            order.setProductName(orderDto.getProductName());
            order.setPrice(orderDto.getPrice());
            order.setQuantity(orderDto.getQuantity());

            order = iOrderRepository.save(order);

            orderDto.setOrderId(order.getOrderId());
            orderDto.setOrderDetailId(order.getOrderDetailId());
            orderDto.setProductId(order.getProductId());
            orderDto.setPrice(order.getPrice());
            orderDto.setProductName(order.getProductName());
            orderDto.setQuantity(order.getQuantity());
            return orderDto;
        } catch (Exception e) {
            throw new OrderException(MessageCauseException.ORDER_CAUSE_EXCEPTION + e);
        }
    }

    @Override
    public List<OrderDetailDto> listOrders(long orderid) throws OrderException {
        try{
            List<OrderDetail> orderdetails = iOrderRepository.findAll();
            List<OrderDetailDto> orderdetailsDto = new ArrayList();
            for(OrderDetail p: orderdetails){
                if(p.getOrderId() == orderid) {
                    OrderDetailDto pDto = new OrderDetailDto();
                    pDto.setOrderId(p.getOrderId());
                    pDto.setOrderDetailId(p.getOrderDetailId());
                    pDto.setProductId(p.getProductId());
                    pDto.setPrice(p.getPrice());
                    pDto.setProductName(p.getProductName());
                    pDto.setQuantity(p.getQuantity());
                    orderdetailsDto.add(pDto);
                }
            }
            return orderdetailsDto;
        }catch(Exception e){
            throw new OrderException(MessageCauseException.ORDER_CAUSE_EXCEPTION + e);
        }
    }
}
