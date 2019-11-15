package com.TouresBalon.Orders.dto;

import lombok.Data;

@Data
public class RequestApiDto<T> {
    private T data;
}
