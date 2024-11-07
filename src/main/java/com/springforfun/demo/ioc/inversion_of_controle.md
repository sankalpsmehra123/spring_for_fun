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
> These are handled over to an external entity. So, we just declare that we are depending on this thing and does not controle the supply.

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

