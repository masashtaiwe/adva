package com.example.logine;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int nextOrderNumber = 1001;

    private int orderNumber;
    private String customerName;
    private DeliveryOption deliveryOption;
    private OrderStatus status;
    private List<OrderLine> lines;

    public Order(String customerName, DeliveryOption deliveryOption) {
        this.orderNumber = nextOrderNumber;
        nextOrderNumber++;

        this.customerName = customerName;
        this.deliveryOption = deliveryOption;
        this.status = OrderStatus.NEW;
        this.lines = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        addItem(item, 1);
    }

    public void addItem(MenuItem item, int quantity) {
        if (status != OrderStatus.NEW) {
            throw new IllegalStateException(
                    "Items can only be added to a NEW order.");
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException(
                    "Quantity must be greater than zero.");
        }

        lines.add(new OrderLine(item, quantity));
    }

    public double calculateSubtotal() {
        double subtotal = 0.0;

        for (OrderLine line : lines) {
            subtotal += line.calculateLineTotal();
        }

        return subtotal;
    }

    public double calculateTotal() {
        return calculateSubtotal() + deliveryOption.getFee();
    }

    public double pay(PaymentMethod method) {
        if (status != OrderStatus.NEW) {
            throw new IllegalStateException(
                    "Only a NEW order can be paid.");
        }

        if (lines.isEmpty()) {
            throw new IllegalStateException(
                    "The order must contain at least one item.");
        }

        double amountPaid = method.calculateAmount(calculateTotal());
        status = OrderStatus.PAID;

        return amountPaid;
    }

    public void deliver() {
        if (status != OrderStatus.PAID) {
            throw new IllegalStateException(
                    "Only a PAID order can be delivered.");
        }

        status = OrderStatus.DELIVERED;
    }

    public void cancel() {
        if (status != OrderStatus.NEW) {
            throw new IllegalStateException(
                    "Only a NEW order can be cancelled.");
        }

        status = OrderStatus.CANCELLED;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public OrderStatus getStatus() {
        return status;
    }
}