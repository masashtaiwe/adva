package com.example.logine;

public class CashPayment implements PaymentMethod {
    @Override
    public double calculateAmount(double amount) {
        return amount;
    }
}