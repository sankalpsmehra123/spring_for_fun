package com.springforfun.demo.beanbehaviour;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.springforfun.demo.beanbehaviour")
public class BeanBehaviourMain {
    public static void main(String[] args) {
        // old school way to do things.
        // HelloSpringMessage helloSpringMessage = new HelloSpringMessage();

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanBehaviourMain.class);

        HelloSpringMessagePrototype helloSpringMessage = context.getBean(HelloSpringMessagePrototype.class);
        helloSpringMessage.setHelloString("Hello, Spring!");
        HelloSpringMessagePrototype helloSpringMessage2 = context.getBean(HelloSpringMessagePrototype.class);
        helloSpringMessage.setHelloString("What the Fish !?");
        GreeterBean greeter = context.getBean(GreeterBean.class);

        // System.out.println("methods inside {@link AnnotationConfigApplicationContext}");
        // String[] beanDefinationNamesArray = context.getBeanDefinitionNames();
        // Arrays.stream(beanDefinationNamesArray).forEach(System.out::println);
        // Arrays.stream(beanDefinationNamesArray)
        // .map(beanName -> context.getBeanDefinition(beanName))
        // .forEach(System.out::println);

        System.out.println("methods that we have written");
        System.out.println(helloSpringMessage.getMessage());
        System.out.println(helloSpringMessage2.getMessage());
        greeter.greet();
        greeter.printMessage();

        context.close();
    }
}
