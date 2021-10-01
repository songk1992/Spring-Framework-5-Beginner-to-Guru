package org.springframework.boot.section5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.section5.controllers.*;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Section5Application {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(Section5Application.class, args);

        PetController petController = ctx.getBean("petController", PetController.class);
        System.out.println(petController.whichPetIsTheBest());

        I18nController i18nController = (I18nController) ctx.getBean("i18nController");
        System.out.println(i18nController.sayGreeting());

        MyController myController = (MyController) ctx.getBean("myController");

        System.out.println("----------------------------- Primary Bean");
        System.out.println(myController.sayHello());

        System.out.println("----------------------------- Property");
        PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
        System.out.println(propertyInjectedController.getGreeting());

        System.out.println("----------------------------- Setter");
        SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
        System.out.println(setterInjectedController.getGreeting());

        System.out.println("----------------------------- Constructor");
        ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
        System.out.println(constructorInjectedController.getGreeting());
    }

}