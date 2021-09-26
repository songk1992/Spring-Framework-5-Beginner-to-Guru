package guru.spring5.section3;

import guru.spring5.section3.controllers.MyController;
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
    }

}
