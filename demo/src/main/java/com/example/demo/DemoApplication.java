package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        //OrderService orderService = new OrderService(new PayPalPaymentService());
        //var orderService = context.getBean(OrderService.class);
        //orderService.placeOrder();
	}

    /*@GetMapping
    public String Hw (){
        System.out.println("Recieved");
        return "XD";
    }*/

}
