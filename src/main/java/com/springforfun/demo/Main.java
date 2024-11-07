package com.springforfun.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.springforfun.demo.ioc.Greeter;

@Configuration
@ComponentScan("com.springforfun.demo")
public class Main {
    public static void main(String[] args) {
        // old school way to do things.
        // HelloSpringMessage helloSpringMessage = new HelloSpringMessage();

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        HelloSpringMessage helloSpringMessage = context.getBean(HelloSpringMessage.class);
        Greeter greeter = context.getBean(Greeter.class);

        System.out.println(helloSpringMessage.getMessage());
        greeter.greet();
        greeter.printMessage();

        context.close();
    }
}
