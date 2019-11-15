package com.TouresBalon.Orders.controller;

import com.TouresBalon.Orders.constant.SourceMapping;
import com.TouresBalon.Orders.delegate.IOrderDelegate;
import com.TouresBalon.Orders.dto.OrderDto;
import com.TouresBalon.Orders.dto.RequestApiDto;
import com.TouresBalon.Orders.dto.ResponseApiDto;
import com.TouresBalon.Orders.exception.OrderException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@Slf4j
public class OrderController {
    @Autowired
    private IOrderDelegate iorderDelegate;

    @PostMapping(value = SourceMapping.ORDERCREATE)
    public ResponseApiDto<OrderDto> createOrder(@RequestBody RequestApiDto<OrderDto> requestApiDto) throws OrderException {
        OrderDto orderDto = iorderDelegate.createOrder(requestApiDto);
        return new ResponseApiDto<>(orderDto);
    }

    @GetMapping(value = SourceMapping.ORDERS)
    public ResponseApiDto<List<OrderDto>> listCatalog(@RequestParam(value = "id",required = false)int id) throws OrderException {
        List<OrderDto> pqrDto = iorderDelegate.listOrders(id);
        return new ResponseApiDto<>(pqrDto);
    }
}
