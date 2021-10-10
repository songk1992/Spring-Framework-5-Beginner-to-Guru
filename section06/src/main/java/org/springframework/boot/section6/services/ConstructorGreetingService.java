package org.springframework.boot.section6.services;

public class ConstructorGreetingService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hello World - Constructor";
    }
}
