package org.springframework.boot.section6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.section6.controllers.*;
import org.springframework.boot.section6.datasource.FakeDataSource;
import org.springframework.boot.section6.services.PrototypeBean;
import org.springframework.boot.section6.services.SingletonBean;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Section6Application {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(Section6Application.class, args);

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

        System.out.println("----------------------------- Bean Scopes");
        SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
        System.out.println(singletonBean1.getMyScope());
        SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);
        System.out.println(singletonBean2.getMyScope());

        PrototypeBean prototypeBean1 = ctx.getBean(PrototypeBean.class);
        System.out.println(prototypeBean1.getMyScope());
        PrototypeBean prototypeBean2 = ctx.getBean(PrototypeBean.class);
        System.out.println(prototypeBean2.getMyScope());

        FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
        System.out.println(fakeDataSource.getUserName());
        System.out.println(fakeDataSource.getPassword());
        System.out.println(fakeDataSource.getJdbcUrl());
    }

}