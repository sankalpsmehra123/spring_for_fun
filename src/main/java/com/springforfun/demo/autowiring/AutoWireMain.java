package com.springforfun.demo.autowiring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.springforfun.demo.autowiring")
public class AutoWireMain {
    public static void main(String[] args) {
        // old school way to do things.
        // HelloSpringMessage helloSpringMessage = new HelloSpringMessage();

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AutoWireMain.class);

        // HelloSpringMessage helloSpringMessage = context.getBean(HelloSpringMessage.class);
        // helloSpringMessage.setHelloString("Hello, Spring!");
        GreeterBean greeter = context.getBean(GreeterBean.class);

        // System.out.println("methods inside {@link AnnotationConfigApplicationContext}");
        // String[] beanDefinationNamesArray = context.getBeanDefinitionNames();
        // Arrays.stream(beanDefinationNamesArray).forEach(System.out::println);
        // Arrays.stream(beanDefinationNamesArray)
        // .map(beanName -> context.getBeanDefinition(beanName))
        // .forEach(System.out::println);

        System.out.println("methods that we have written");
        // System.out.println(helloSpringMessage.getMessage());
        greeter.greet();
        greeter.printMessage();

        context.close();
    }
}
