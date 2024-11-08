package com.springforfun.demo.ioc;

// import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.springforfun.demo.ioc")
public class IOCMain {
    public static void main(String[] args) {
        // old school way to do things.
        // HelloSpringMessage helloSpringMessage = new HelloSpringMessage();

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(IOCMain.class);

        HelloSpringMessage helloSpringMessage = context.getBean(HelloSpringMessage.class);
        helloSpringMessage.setHelloString("Hello, Spring!");
        Greeter greeter = context.getBean(Greeter.class);

        // System.out.println("methods inside {@link AnnotationConfigApplicationContext}");
        // String[] beanDefinationNamesArray = context.getBeanDefinitionNames();
        // Arrays.stream(beanDefinationNamesArray).forEach(System.out::println);
        // Arrays.stream(beanDefinationNamesArray)
        // .map(beanName -> context.getBeanDefinition(beanName))
        // .forEach(System.out::println);

        System.out.println("methods that we have written");
        System.out.println(helloSpringMessage.getMessage());
        greeter.greet();
        greeter.printMessage();

        context.close();
    }
}
