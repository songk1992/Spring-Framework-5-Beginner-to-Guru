package org.springframework.boot.section5.controllers;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.section5.services.GreetingService;
import org.springframework.stereotype.Controller;

// Internalization Controller
@Controller
public class I18nController {

    private final GreetingService greetingService;

    public I18nController(@Qualifier("i18nService") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayGreeting(){
        return greetingService.sayGreeting();
    }
}
