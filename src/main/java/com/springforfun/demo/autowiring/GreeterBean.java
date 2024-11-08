package com.springforfun.demo.autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GreeterBean {

    private Message message;

    public GreeterBean(){
    }

    // @Autowired(required = false) this will never work with constructor injections
    @Autowired
    public GreeterBean (@Qualifier("hey") Message message){
        System.out.println("called the constructor!");
        this.message = message;
    }

    public void printMessage(){
        System.out.println(message.getMessage());
    }

    public void greet() {
        System.out.println("How Are you?");
    }

    public Message getMessage() {
        return message;
    }

    @Autowired(required = false)
    public void setHelloSpringMessage(@Qualifier("hey") Message message) {
        System.out.println("called the setter!");
        this.message = message;
    }
}
