package org.springframework.boot.section6.config;

import com.springframework.pets.PetService;
import com.springframework.pets.PetServiceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.section6.datasource.FakeDataSource;
import org.springframework.boot.section6.repositories.EnglishGreetingRepository;
import org.springframework.boot.section6.repositories.EnglishGreetingRepositoryImpl;
import org.springframework.boot.section6.services.*;
import org.springframework.context.annotation.*;

@PropertySource("classpath:datasource.properties")
@ImportResource("classpath:sfgdi-config.xml")
@Configuration
public class GreetingServiceConfig {

    @Bean
    FakeDataSource fakeDataSource(@Value("${guru.user_name}")String userName,
                                  @Value("${guru.password}")String password,
                                  @Value("${guru.jdbc_url}")String jdbcUrl){
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUserName(userName);
        fakeDataSource.setPassword(password);
        fakeDataSource.setJdbcUrl(jdbcUrl);
        return fakeDataSource;
    }

    @Bean
    PetServiceFactory petServiceFactory(){
        return new PetServiceFactory();
    }
    @Bean
    @Profile({"DOG", "default"})
    PetService dogPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("DOG");
    }
    @Bean
    @Profile({"CAT"})
    PetService catPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("CAT");
    }


    @Profile({"ESP", "default"})
    @Bean("i18nService")
    I18nSpanishGreetingService i18nSpanishGreetingService(){
        return new I18nSpanishGreetingService();
    }

    @Profile("KOR")
    @Bean("i18nService")
    I18nKoreanGreetingService i18nService(){
        return new I18nKoreanGreetingService();
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository(){
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile("ENG")
    @Bean("i18nService")
    I18nEnglishGreetingService i18nEnglishGreetingService(EnglishGreetingRepository englishGreetingRepository){
        return new I18nEnglishGreetingService(englishGreetingRepository);}

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService(){
        return new PrimaryGreetingService();
    }


    //@Bean
    //ConstructorGreetingService constructorGreetingService(){
    //    return new ConstructorGreetingService();
    //    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService(){
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService(){
        return new SetterInjectedGreetingService();
    }
}
