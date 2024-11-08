package com.springforfun.demo.autowiring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("hello")
public class HelloSpringMessage implements Message {

    public HelloSpringMessage(){
        
    }

    String helloString;
    
    @Override
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
