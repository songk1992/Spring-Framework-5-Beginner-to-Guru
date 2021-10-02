package org.springframework.boot.section6.services;

public class I18nSpanishGreetingService implements GreetingService{
    @Override
    public String sayGreeting(){
        return "Hola";
    }
}
