package com.example.logine;

public class ExpressDelivery implements DeliveryOption {
    @Override
    public double getFee() {
        return 5.0;
    }
}