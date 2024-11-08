package com.springforfun.demo.beanbehaviour;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.springforfun.demo.ioc.OptionalDependency;

@Component
@Lazy
public class GreeterBean {

    private Message helloSpringMessage;

    public GreeterBean(){
    }

    // @Autowired(required = false) this will never work with constructor injections
    @Autowired
    public GreeterBean (Message helloSpringMessage){
        System.out.println("called the constructor!");
        this.helloSpringMessage = helloSpringMessage;
    }

    public void printMessage(){
        System.out.println(helloSpringMessage.getMessage());
    }

    public void greet() {
        System.out.println("How Are you?");
    }

    public Message getHelloSpringMessage() {
        return helloSpringMessage;
    }

    @Autowired(required = false)
    public void setHelloSpringMessage(Message helloSpringMessage, OptionalDependency optionalDependency) {
        System.out.println("called the setter!");
        this.helloSpringMessage = helloSpringMessage;
    }
}
