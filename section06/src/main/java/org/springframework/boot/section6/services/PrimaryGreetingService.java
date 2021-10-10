package org.springframework.boot.section6.services;

public class PrimaryGreetingService implements GreetingService{
    @Override
    public String sayGreeting(){
        return "Hello World - From the Primary bean";
    }
}
