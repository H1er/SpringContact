package com.example.demo.dependencyInjectionExamples;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    //sacar el valor de una variable del application.properties
    @Value("${app.value-demo}")
    private String propertiesValue;

    @RequestMapping("/")
    public String index(){

        //System.out.println("value demo: "+propertiesValue);
        return "index.html";

    }
}
