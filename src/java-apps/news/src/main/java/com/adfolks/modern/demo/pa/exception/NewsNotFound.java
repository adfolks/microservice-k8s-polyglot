package com.adfolks.modern.demo.pa.exception;

public class NewsNotFound extends RuntimeException {

    public NewsNotFound(String message) {
        super(message);
    }
}
