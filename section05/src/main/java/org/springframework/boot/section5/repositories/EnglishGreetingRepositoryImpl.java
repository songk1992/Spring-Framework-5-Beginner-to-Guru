package org.springframework.boot.section5.repositories;

public class EnglishGreetingRepositoryImpl implements EnglishGreetingRepository {
    @Override
    public String getGreeting(){
        return "Hello World - ENG";
    }
}
