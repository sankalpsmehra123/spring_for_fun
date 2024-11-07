package com.springforfun.demo.ioc;

import org.springframework.stereotype.Component;

import com.springforfun.demo.HelloSpringMessage;

@Component
public class Greeter {

    HelloSpringMessage helloSpringMessage;

    public Greeter (HelloSpringMessage helloSpringMessage){
        this.helloSpringMessage = helloSpringMessage;
    }

    public void printMessage(){
        System.out.println(helloSpringMessage.getMessage());
    }

    public void greet() {
        System.out.println("How Are you?");
    }
}
