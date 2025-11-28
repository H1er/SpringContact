package com.example.demo.dependencyInjectionExamples;

public class StripePaymentService implements PaymentService {
    @Override
    public void processPayment(double amount){
        System.out.println("Strip: Payment amount "+amount+" processed");
    }
}
