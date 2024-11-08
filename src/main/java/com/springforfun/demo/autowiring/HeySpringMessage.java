package com.springforfun.demo.autowiring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("Hey")
@Primary
public class HeySpringMessage implements Message {

    public HeySpringMessage() {}

    String helloString = "Hey spring";
    
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
