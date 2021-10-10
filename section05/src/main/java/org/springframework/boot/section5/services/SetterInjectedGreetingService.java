package org.springframework.boot.section5.services;

public class SetterInjectedGreetingService implements GreetingService{
    @Override
    public String sayGreeting(){
        return "Hello World - Setter";
    }
}
