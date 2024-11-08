package com.springforfun.demo.ioc;

import org.springframework.stereotype.Component;

@Component
public class HelloSpringMessage {

    String helloString;
    
    public String getMessage() {
        return this.helloString;
    }

    public String getHelloString() {
        return helloString;
    }

    public void setHelloString(String helloString) {
        this.helloString = helloString;
    }
}
