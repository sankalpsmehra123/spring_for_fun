# Bean Behaviour

## Default behaviour of beans

1. Eager (This is explained in javaconfig package classes)
2. Singleton (This is only in the context of spring not the whole application)

#### What does eager mean? How to change that behaviour?

This means that the beans are created when the container is initialized but there are ways for ***lazy initialization*** using `@Lazy` annotation.

> There is a catch here if a eager bean is dependent on a lazy bean then the lazy bean gets initiallized at the start of the container.

#### What is singleton? How to change that behaviour?

It means that there can only be one object of it but there are ways we can make multipule instances of same class using the `@Scope("prototype")` annotation.

#### What is a bean scope?

| Property | Singleton | Prototype |
|-------------|-----------|--------------|
| when the bean is created? | when application starts | when bean is injected / looked up |
| how many beans are created? | one bean | as many as needed |
| when the bean is distroyed? | when application ends | when the application ends |
| how to specify | `@Scope("singleton")` / not needed | `@Scope("prototype")` |

### Web Scopes

these are scopes needed for web applications that never ends. Some of examples are:

* Request `@Scope("request")` creates new instance for each new request and provides the same instance for the same request every time
* Session `@Scope("session")` creates new instance for each new session and provides the same instance for the same session every time
* Application `@Scope("application")` creates new instance for each new application and provides the same instance for the same application every time

## Order of Creation of Beans

Creates it in dependency order.

Q: But what if 2 beans are independent?
A: By defualt spring can initialize in any order. However, if we want a specific order we can specify one using the annotation `@DependsOn("<bean_name>")` 

> There is another annotation `@Order` this is NOT used to specify order of creation but instead used for ordering the addition to a collection of beans. will show by example

Example for Order:

```java
    public interface Task() {
        
    }

    @Component
    @Order(2)
    public class TaskA implements Task {

    }

    @Component
    @Order(1)
    public class TaskB implements Task {
        
    }

    @Component
    public class TaskRunner implements Task {
        @Autowired
        private List<Task> tasks; 
        // this list will have object of TaskB before object of TaskA
    }
```

## Lifecycle Callback

every bean has a lifecycle. Sometimes in a spring application we want do certain things in between lifecycle events. This is where the concept of lifecycle callback comes into picture.

> ***NOTE:*** we need jakarta.annotation dependency to use the below annotation callbacks

#### How to set it up?

1. Write the code to run on create and destroy (methods)
2. Annotate it
3. Spring calls it at the right time

Here we use 2 annotations which controle this:
1. `@PostConstruct` example is after initializing the bean of database we can do db connection establishment using this annotation or throw some exception if that fails
2. `@PreDestroy` example is befor destroying the bean of database we close the connection to the database or throw some exception if that fails


```java
    public interface Task() {
        
    }

    @Component
    @Order(2)
    public class TaskA implements Task {

    }

    @Component
    @Order(1)
    public class TaskB implements Task {

        @PostConstruct
        public void init() {
            // initialization code
        }

        @PreDestroy
        public void close() {
            // closing code
        }
    }

    @Component
    public class TaskRunner implements Task {
        @Autowired
        private List<Task> tasks; 
        // this list will have object of TaskB before object of TaskA
    }
```

Q: Why not use constructor instead of post constructor annotation?
A: Writing the code at the time of initializing in the constructor need to handle NPE in all its dependency variables. The annotation gets called after the DI has been done. Adding to that there is benifit of seperation of concerns i.e. seperating the creation logic with the initialization logic and same in the case of desctruction.
