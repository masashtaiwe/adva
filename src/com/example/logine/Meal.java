package com.example.logine;

public class Meal extends MenuItem {
    private int extraToppings;

    public Meal(String name, double basePrice, int extraToppings) {
        super(name, basePrice);
        this.extraToppings = extraToppings;
    }

    @Override
    public double calculateFinalPrice() {
        return getBasePrice() + (extraToppings * 1.5);
    }
}