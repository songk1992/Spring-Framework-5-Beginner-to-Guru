package guru.spring5.section3;

import guru.spring5.section3.controllers.ConstructorInjectedController;
import guru.spring5.section3.controllers.MyController;
import guru.spring5.section3.controllers.PropertyInjectedController;
import guru.spring5.section3.controllers.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Section3Application {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(Section3Application.class, args);

        MyController myController = (MyController) ctx.getBean("myController");

        String greeting = myController.sayHello();

        System.out.println(greeting);

        System.out.println("----------------------------- Property");

        PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");

        greeting = propertyInjectedController.getGreeting();

        System.out.println(greeting);

        System.out.println("----------------------------- Setter");

        SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");

        System.out.println(setterInjectedController.getGreeting());

        System.out.println("----------------------------- Constructor");

        ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");

        System.out.println(constructorInjectedController.getGreeting());
    }

}
