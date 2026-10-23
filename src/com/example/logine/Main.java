package com.example.logine;

public class Main {
    public static void main(String[] args) {
        Meal burger = new Meal("Burger Meal", 8.0, 1);
        Drink juice = new Drink("Juice", 3.0, true);

        Order order = new Order(
                "Ahmad",
                new ExpressDelivery()
        );

        order.addItem(burger, 2);
        order.addItem(juice);

        System.out.println("Order number: " + order.getOrderNumber());
        System.out.println("Subtotal: " + order.calculateSubtotal());
        System.out.println("Total: " + order.calculateTotal());

        double paidAmount = order.pay(new CardPayment());

        System.out.println("Paid by card: " + paidAmount);
        System.out.println("Status: " + order.getStatus());
    }
}