package com.systemdesign.lld.paymentservice.service.processor;

import com.systemdesign.lld.paymentservice.model.PaymentRequest;
import com.systemdesign.lld.paymentservice.model.PaymentResponse;
import com.systemdesign.lld.paymentservice.service.gateway.PaymentGateway;

public class CardPaymentProcessor implements PaymentProcessor {

    private PaymentGateway gateway;

    public CardPaymentProcessor(PaymentGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public PaymentResponse pay(PaymentRequest request) {

        // Handles card validations such as expiry, CVV, and authentication

        return gateway.charge(request);
    }
}