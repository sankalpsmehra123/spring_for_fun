package com.springforfun.demo.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;



@Configuration
public class JavaConfigMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfigMain.class);
        GreeterJavaConfig greeterJavaConfig = context.getBean(GreeterJavaConfig.class);

        greeterJavaConfig.greet();
        context.close();
    }

    @Bean
    @Lazy
    public GreeterJavaConfig greeterConfig (HelloSpringMessageJavaConfig helloSpringMessageJavaConfig, String greetingMessage){
        return new GreeterJavaConfig(helloSpringMessageJavaConfig, greetingMessage);
    }

    @Bean
    public HelloSpringMessageJavaConfig helloSpringConfig (){
        return new HelloSpringMessageJavaConfig();
    }

    @Bean
    public String greetingMessageConfig (){
        System.out.println("called the greetingMessage constructor!");
        return "This greeting is from javaConfig bean";
    }
}
