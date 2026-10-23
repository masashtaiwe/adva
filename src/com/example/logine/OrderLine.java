package com.example.logine;

public class OrderLine {
    private MenuItem item;
    private int quantity;

    public OrderLine(MenuItem item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public double calculateLineTotal() {
        return item.calculateFinalPrice() * quantity;
    }
}