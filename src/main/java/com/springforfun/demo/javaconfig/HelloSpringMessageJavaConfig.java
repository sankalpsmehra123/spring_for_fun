package com.springforfun.demo.javaconfig;

public class HelloSpringMessageJavaConfig {

    public HelloSpringMessageJavaConfig() {
        System.out.println("called the HelloSpringMessageJavaConfig constructor!");
    }

    public String getMessage() {
        return "Hello, Spring!";
    }
}
