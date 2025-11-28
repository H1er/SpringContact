package com.example.demo.dependencyInjectionExamples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
    private PaymentService paymentService;

    public OrderService(PaymentService ps, int x){

    }
    @Autowired
    public OrderService(PaymentService ps){
        this.paymentService=ps;
    }

    public void placeOrder(){
        paymentService.processPayment(100);
    }

    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
}
