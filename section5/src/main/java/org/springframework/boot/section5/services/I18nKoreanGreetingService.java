package org.springframework.boot.section5.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("KOR")
@Service("i18nService")
public class I18nKoreanGreetingService implements GreetingService{
    @Override
    public String sayGreeting(){
        return "안뇽";
    }
}
