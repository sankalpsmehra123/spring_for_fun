# Spring For Fun
This repository is for learning spring, notes and questions

## Background

#### What are the steps involved in build a complex application with core java?

1. Connect to DB using JDBC.
2. Transaction management for DB.
3. Authentication and autharization (passwords etc).
4. Build web applications/ APIs.
5. External services.
6. Testing - unit, integration etc.
5. Complex server deployments.

Application frameworks solve all these challenges.

#### What is an application framework?

1. A software platform, not a library. So it is something that takes your code and runs it, unlike a library which you invoke and ask it to do a task for you.
2. Provides a structured enviornment. (like guidelines)
3. Helps in building and running applications.
4. Offers prebuilt components, libraries and tools.
5. Handles common tasks.
6. Makes experience consistant and supports development standards.

One such framework is ***Spring***.

#### Coding in Framework

1. It does things that you have to do. But you have to ask it to.
2. Follow its rules in your code.
3. Place your code in the framework.

## Why Spring?

Most popular java framework.  
"Makes programming java easier, quicker and safer for everybody. Focus is on speed, simplicity and productivity."  
~ Spring Website

#### What is included in spring?

1. Core framework
2. Family of frameworks and libraries.
3. Solutions for common concenrs.
4. So many common concerns.

### Spring Family

1. Spring core (basics of spring)
2. Spring boot (for java applications)
3. Spring MVC (for web applications)
4. Spring data (for Interacting with data)
5. Spring security (authentication and autharization)
6. Spring integrations (for working with other application/services)
7. Spring cloud (for working with cloud services)
8. Spring batch (for doing batch operations) ...etc.
  
> Good thing is Spring is ***Modular***. But there are too many of them.
To resolve this there was a new project added to the family called ${\color{green}SpringBoot}$ which is like ***openionated starting points***.

### Simplified Configuration

With annotations and java-based configuration, Spring simplifies the setup configuration of applications.

### Dependency Management

Spring's ***Inversion of Controle*** containers handles the lifecycle and configuration of application objects, which simplifies dependency management.

### Data Access

Spring provides a JDBC template to handle the boilerplate code assosiated with db operations.
It also integerates well with Hybernate and JPA for ORM (Object Relational Mapping).

### Transactions

Spring provides declarative transaction management feature that eleminates the need of manual transaction handling in your code.

### Integration

Provides integration APIs for working with various technologies like JSM, REST and many more.

### Security

Spring security simplifies implementation of complex features like authentication and autharization.

### Testing

Provides execlent support for both unit testing and integration testing.

### Microservices

With Spring boot and Spring cloud, it's easier to develope microservice based applications, manage configurations accross multipule servicesm, implement service discovery etc.

## Links

[***Inversion Of Control***](/src/main/java/com/springforfun/demo/ioc/inversion_of_controle.md)