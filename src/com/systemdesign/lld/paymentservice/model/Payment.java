package com.systemdesign.lld.paymentservice.model;

public class Payment {

    private String paymentId;
    private String orderId;
    private double amount;
    private PaymentStatus status;
    private PaymentMode paymentMode;

    // Stores payment transaction details for auditing and reconciliation
}
