package com.springforfun.demo.javaconfig;

import org.springframework.beans.factory.annotation.Autowired;


public class GreeterJavaConfig {

    private HelloSpringMessageJavaConfig helloSpringMessage;
    private String greetingMessage;

    // @Autowired(required = false) this will never work with constructor injections
    @Autowired
    public GreeterJavaConfig (HelloSpringMessageJavaConfig helloSpringMessage, String greetingMessage){
        System.out.println("called the GreeterJavaConfig constructor!");
        this.helloSpringMessage = helloSpringMessage;
        this.greetingMessage = greetingMessage;
    }

    public void printMessage(){
        System.out.println(helloSpringMessage.getMessage());
    }

    public void greet() {
        System.out.println("How Are you?");
        System.out.println(greetingMessage);
    }
}
