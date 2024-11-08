# Autowiring

* ***Type (Default):*** uses class type to autowire dependencies
* ***Name:*** uses name type to autowire dependencies

#### What is the issue with auto wiring by type?

The problem is that there might be multipule instances of that type. We solve this problem by using ***Qualifiers*** with `@Qualifier("<NAME>")` annotation.

#### What are the steps to do this?

1. Add qualifiers to beans
2. Autowire by name in front of the parameter

Q: There is a application in which we wrote only one implementation of an interface initially but later on realized that we need another implementation also should we add @Qualifier in front of every parameter in the whole code where we are using this interface?

A: No. we can using something called as the defualt qualifier which can be done using annotation `@Primary`. This annotation marks a certain bean as the main bean