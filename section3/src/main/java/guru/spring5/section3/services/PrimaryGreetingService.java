package guru.spring5.section3.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class PrimaryGreetingService implements GreetingService{
    @Override
    public String sayGreeting(){
        return "Hello World - From the Primary bean";
    }
}
