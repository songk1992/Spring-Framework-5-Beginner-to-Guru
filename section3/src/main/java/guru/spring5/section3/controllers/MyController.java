package guru.spring5.section3.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class MyController {
    public String sayHello(){
        System.out.println("Hello World");

        return "Hi People";
    }
}
