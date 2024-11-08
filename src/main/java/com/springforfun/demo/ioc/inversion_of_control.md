# Inversion Of Control

## Wy IOC is great?

Let us understand with an example

### Example

we are building a e-commerce website where we have 2 classes an OrderService and a PaymentService. 
In order to complete the order of a customer the OrderService needs to call the PaymentService.

#### How to do it ?

```java
public class OrderSevice {
    private PaymentService paymentService;

    public OrderService() {
        paymentService = new PaymentService();
    }

    public boolean processPayment() {
        return paymentService.processPayment();
    }
}

public class PaymentService {

    public PaymentService(){}

    public boolean processPayment(){
        // code to do the payment
    }
}
```

In a traditional control flow you have to manage the object dependencies. 

#### So, whats the big deal?

#### The control problem

1. Tight coupling
2. Lack of flexibility
3. Maintainance challanges
4. Testing challenges

#### So, what is the solution?

1. The service locator pattern
2. Inversion of control

> **_Service Locator Pattern_**:  
> In this pattern if a class A required an object of class B then it asks a coordinator to send the Object that it requires.  
> If it is a production enviornment then the coordinator send the real Object of B.  
> If it is a non-prod env then the coordinator sends a mocked Object of B.

> **_Inversion of control_**:  
> Control gets inverted and dependencies are no longer managed by the objects themselves.  
> These are handled over to an external entity. So, we just declare that we are depending on this thing and does not control the supply.

```java
public class OrderSevice {
    private PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public boolean processPayment() {
        return paymentService.processPayment();
    }
}

public class PaymentService {

    public PaymentService(){}

    public boolean processPayment(){
        // code to do the payment
    }
}
```
## Benifits of IOC

1. Promots Loose Coupling
2. Enhances modularity and flexibility
3. Facilitates easier testing and mantainance

## Drawback of IOC

1. Control goes somewhere else but work still needs to be done.

> **_Spring Framework_** injects the dependencies so that you don't have to.  
> **_Your Classes_** specify what they need and **_Spring Framework_** provides what your classes asked for.

#### How does spring do it ?

1. Provides a container
2. Fulfills the requirements.

## The Spring IOC Container

Springs implementation of IOC.

#### Two Key Packages

1. "org.springframework.beans": Has all the things related to managing the beans.
2. "org.springframework.context": It is the space where the things exist.

### Application Context

1. Represents the container context in Spring
2. It is called a bean factory (factory design pattern).
3. Manages your application beans and adds more enterprise application support.

It is responsible for managing and providing a runtime enviornment for Spring based applications.

#### Functionality

1. This ***Application Context*** is created during the startup phase.
2. It reads the dependencise and configurations.
3. It then wires the different components togather.
4. Also, manages the lifecycle of bean through [bean registry](inversion_of_control.md#bean-registry) etc.

#### Bean Registry

* Registry of all the beans in the Spring application.
* Used by the ApplicationContext for managing the beans.
* ApplicationContext reads from config to create these definations.
* We can see this ***bean registry*** `getBeanDefinationNames()` method in the context class.

## Types of Dependecy Injection

1. Constructor based DI. (this gives error in case of circular injections)
2. Setter based DI. (this is better for circular injections if needed)
3. Field Injections (Autowiring the property directly. Never use)

***Constructor injection*** is the recomended one to use.  

This is because of the following reasons:
* The object is never null
* Component is always in the fully initialized state
* Best for mandatory dependency

On the other hand **_setter injection_** is recomended when:
* Having too many dependencies
* When dependencies are optional

We should NOT use ***field injection*** because of the following reasons: 
* You loose controle over the process
* Reflection

Q: How does **field injection** work even on a private variable of a class?  
A: Using a conept called ***Reflection***. (Takes help of a class ReflectionUtils)

Example:

```java
    // Constructor based.
    public class Greeter {
        @Autowired
        public Greeter(HelloWorld helloWorld){

        }
    }
    
    // Setter based.
    public class Greeter {
        private HelloWorld helloWorld;

        @Autowired
        public setHelloWorld(HelloWorld helloWorld){
            this.helloWorld = helloWorld;
        }
    }

    // Field based. Never Use
    public class Greeter {
        @Autowired
        HelloWorld helloWorld;
    }
```

#### How does context do that?

1. Dependency resolution process.
2. Bean creation and initialization.
3. Dependency resolution strategies.
4. Then does DI.

> ***Optional Dependencies:*** are dependencies which when not present the application does not stop. example in class A we have a dependency of an interface for which there is no implementations then  we can add an optional dependency

#### What are best practices of optional dependencies?

* Clearly call out that they are optional.
* Handle null checks.
* Do not rely on it for core functionality.