package com.springforfun.demo.beanbehaviour;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class HelloSpringMessagePrototype implements Message {

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
