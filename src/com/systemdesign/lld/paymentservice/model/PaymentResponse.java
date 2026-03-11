package com.systemdesign.lld.paymentservice.model;

public class PaymentResponse {

    private String paymentId;
    private PaymentStatus status;

    // Response returned after payment attempt


    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }
}