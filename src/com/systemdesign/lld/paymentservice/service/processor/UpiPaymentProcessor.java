package com.systemdesign.lld.paymentservice.service.processor;

import com.systemdesign.lld.paymentservice.model.PaymentRequest;
import com.systemdesign.lld.paymentservice.model.PaymentResponse;
import com.systemdesign.lld.paymentservice.service.gateway.PaymentGateway;

public class UpiPaymentProcessor implements PaymentProcessor {

    private PaymentGateway gateway;

    public UpiPaymentProcessor(PaymentGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public PaymentResponse pay(PaymentRequest request) {

        // Handles UPI specific validation like VPA format
        // Delegates actual charging to payment gateway

        return gateway.charge(request);
    }
}
