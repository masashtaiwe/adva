package com.example.logine;

public class Drink extends MenuItem {
    private boolean isLarge;

    public Drink(String name, double basePrice, boolean isLarge) {
        super(name, basePrice);
        this.isLarge = isLarge;
    }

    @Override
    public double calculateFinalPrice() {
        if (isLarge) {
            return getBasePrice() + 1.0;
        }

        return getBasePrice();
    }
}