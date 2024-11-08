# Java Config

#### What are ways to specify dependencies in Spring app?

* Using annotations
* Using XML (Benifit: No code change)
* Using Java Classes (Java Config)

## Using Java Config

* Alternative way of managing dependencies
* Write java code just for this purpose
* Both define bean and wire dependencies

#### How to do it?

1. Create a class annotated with `@Configuration` so that Spring knows this is configuration.
2. Create a method which returns a Bean instance and annotate it with `@Bean`

#### What are the benifits?

* Type safety (compared to XML)
* Programatic flexibility