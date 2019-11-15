package com.TouresBalon.Orders.dto;

import lombok.Data;

@Data
public class ResponseApiDto<T> {
    private T data;

    public ResponseApiDto(T data) {
        this.data = data;
    }

    public T getData() { return this.data; }
}
