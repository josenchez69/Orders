package com.TouresBalon.Orders.exception;

import com.TouresBalon.Orders.constant.MessageServiceException;

public class OrderException extends Exception {
    public OrderException(String cause) {
        super(String.format("%s%s", MessageServiceException.ORDER_EXCEPTION, cause));
    }
}
