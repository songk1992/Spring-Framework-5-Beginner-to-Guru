package org.springframework.boot.section5.services;

public class I18nKoreanGreetingService implements GreetingService{
    @Override
    public String sayGreeting(){
        return "안뇽";
    }
}
