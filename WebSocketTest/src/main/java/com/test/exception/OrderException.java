package com.test.exception;

public class OrderException extends RuntimeException {

    public OrderException() {
        super("请在正确的范围内取值");
    }

    public OrderException(String e) {
        super(e);
    }
}
