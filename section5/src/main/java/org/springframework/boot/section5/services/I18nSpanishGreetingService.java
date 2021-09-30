package org.springframework.boot.section5.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


public class I18nSpanishGreetingService implements GreetingService{
    @Override
    public String sayGreeting(){
        return "Hola";
    }
}
