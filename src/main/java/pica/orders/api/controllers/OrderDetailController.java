package com.TouresBalon.Orders.controller;

import com.TouresBalon.Orders.constant.SourceMapping;
import com.TouresBalon.Orders.delegate.IOrderDetailDelegate;
import com.TouresBalon.Orders.dto.OrderDetailDto;
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
public class OrderDetailController {
    @Autowired
    private IOrderDetailDelegate iOrderDetailDelegate;

    @PostMapping(value = SourceMapping.ORDERDETCREATE)
    public ResponseApiDto<OrderDetailDto> createOrderDetail(@RequestBody RequestApiDto<OrderDetailDto> requestApiDto) throws OrderException {
        OrderDetailDto orderdetDto = iOrderDetailDelegate.createOrderDetail(requestApiDto);
        return new ResponseApiDto<>(orderdetDto);
    }

    @GetMapping(value = SourceMapping.ORDERDET)
    public ResponseApiDto<List<OrderDetailDto>> listOrders(@RequestParam(value = "id",required = false)int id) throws OrderException {
        List<OrderDetailDto> pqrDto = iOrderDetailDelegate.listOrders(id);
        return new ResponseApiDto<>(pqrDto);
    }
}
