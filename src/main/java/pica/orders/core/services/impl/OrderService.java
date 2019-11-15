package com.TouresBalon.Orders.service.impl;

import com.TouresBalon.Orders.constant.MessageCauseException;
import com.TouresBalon.Orders.dto.OrderDto;
import com.TouresBalon.Orders.entity.Order;
import com.TouresBalon.Orders.repository.IOrderRepository;
import com.TouresBalon.Orders.service.IOrderService;
import com.TouresBalon.Orders.exception.OrderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private IOrderRepository iOrderRepository;

    @Override
    public OrderDto createOrder(OrderDto orderDto) throws OrderException {
        try {
            Order order = new Order();
            order.setOrderId(orderDto.getOrderId());
            order.setCustomerId(orderDto.getCustomerId());
            order.setOrderDate(orderDto.getOrderDate());
            order.setPrice(orderDto.getPrice());
            order.setStatus(orderDto.getStatus());
            order.setComments(orderDto.getComments());

            order = iOrderRepository.save(order);


            orderDto.setOrderId(order.getOrderId());
            orderDto.setCustomerId(order.getCustomerId());
            orderDto.setOrderDate(order.getOrderDate());
            orderDto.setPrice(order.getPrice());
            orderDto.setStatus(order.getStatus());
            orderDto.setComments(order.getComments());
            return orderDto;
        } catch (Exception e) {
            throw new OrderException(MessageCauseException.ORDER_CAUSE_EXCEPTION + e);
        }
    }

        @Override
        public List<OrderDto> listOrders(long customerid) throws OrderException {
            try{
                List<Order> userOrders = iOrderRepository.findAll();
                List<OrderDto> userOrdersDto = new ArrayList();
                for(Order p: userOrders){
                    if(p.getCustomerId() == customerid) {
                        OrderDto pDto = new OrderDto();
                        pDto.setOrderId(p.getOrderId());
                        pDto.setCustomerId(p.getCustomerId());
                        pDto.setOrderDate(p.getOrderDate());
                        pDto.setPrice(p.getPrice());
                        pDto.setStatus(p.getStatus());
                        pDto.setComments(p.getComments());
                        userOrdersDto.add(pDto);
                    }
                }
                return userOrdersDto;
            }catch(Exception e){
                throw new OrderException(MessageCauseException.ORDER_CAUSE_EXCEPTION + e);
            }
    }
}
