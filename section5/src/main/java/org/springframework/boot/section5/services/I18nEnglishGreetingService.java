package org.springframework.boot.section5.services;

import org.springframework.boot.section5.repositories.EnglishGreetingRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


public class I18nEnglishGreetingService implements GreetingService{

    private final EnglishGreetingRepository englishGreetingRepository;

    public I18nEnglishGreetingService(EnglishGreetingRepository englishGreetingRepository) {
        this.englishGreetingRepository = englishGreetingRepository;
    }

    @Override
    public String sayGreeting(){
        return englishGreetingRepository.getGreeting();
    }
}
