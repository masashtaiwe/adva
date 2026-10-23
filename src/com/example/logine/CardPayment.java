package com.example.logine;

public class CardPayment implements PaymentMethod {
    private static final double FEE_RATE = 0.02;

    @Override
    public double calculateAmount(double amount) {
        return amount + (amount * FEE_RATE);
    }
}