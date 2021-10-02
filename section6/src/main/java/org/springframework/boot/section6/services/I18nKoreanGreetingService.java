package org.springframework.boot.section6.services;

public class I18nKoreanGreetingService implements GreetingService{
    @Override
    public String sayGreeting(){
        return "안뇽";
    }
}
