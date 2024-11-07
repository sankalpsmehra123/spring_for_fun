package com.springforfun.demo;

import org.springframework.stereotype.Component;

@Component
public class HelloSpringMessage {
    public String getMessage() {
        return "Hello, Spring!";
    }
}
