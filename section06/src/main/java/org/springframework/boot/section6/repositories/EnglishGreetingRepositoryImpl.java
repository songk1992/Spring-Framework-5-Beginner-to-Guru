package org.springframework.boot.section6.repositories;

public class EnglishGreetingRepositoryImpl implements EnglishGreetingRepository {
    @Override
    public String getGreeting(){
        return "Hello World - ENG";
    }
}
