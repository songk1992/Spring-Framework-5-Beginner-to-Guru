package guru.spring5.section3.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("ENG")
@Service("i18nService")
public class I18nEnglishGreetingService implements GreetingService{
    @Override
    public String sayGreeting(){
        return "Hello";
    }
}
