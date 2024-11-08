package com.springforfun.demo.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Greeter {

    private HelloSpringMessage helloSpringMessage;
    private OptionalDependency optionalDependency;

    public Greeter(){
    }

    // @Autowired(required = false) this will never work with constructor injections
    @Autowired
    public Greeter (HelloSpringMessage helloSpringMessage){
        System.out.println("called the constructor!");
        this.helloSpringMessage = helloSpringMessage;
    }

    public void printMessage(){
        System.out.println(helloSpringMessage.getMessage());
    }

    public void greet() {
        if(optionalDependency != null){
            System.out.println("Optional Dependency present");
        } else {
            System.out.println("Optional Dependency not present");
        }
        System.out.println("How Are you?");
    }

    public HelloSpringMessage getHelloSpringMessage() {
        return helloSpringMessage;
    }

    @Autowired(required = false)
    public void setHelloSpringMessage(HelloSpringMessage helloSpringMessage, OptionalDependency optionalDependency) {
        System.out.println("called the setter!");
        this.helloSpringMessage = helloSpringMessage;
        this.optionalDependency = optionalDependency;
    }
}
