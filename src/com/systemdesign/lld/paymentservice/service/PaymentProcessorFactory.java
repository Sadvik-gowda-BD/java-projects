package com.systemdesign.lld.paymentservice.service;

import com.systemdesign.lld.paymentservice.model.PaymentMode;
import com.systemdesign.lld.paymentservice.service.gateway.RazorpayGateway;
import com.systemdesign.lld.paymentservice.service.gateway.StripeGateway;
import com.systemdesign.lld.paymentservice.service.processor.CardPaymentProcessor;
import com.systemdesign.lld.paymentservice.service.processor.PaymentProcessor;
import com.systemdesign.lld.paymentservice.service.processor.UpiPaymentProcessor;

import java.util.HashMap;
import java.util.Map;

// Factory returns correct processor based on payment mode
public class PaymentProcessorFactory {

    private static final PaymentProcessorFactory INSTANCE =
            new PaymentProcessorFactory();

    private Map<PaymentMode, PaymentProcessor> processorMap = new HashMap<>();

    private PaymentProcessorFactory() {

        processorMap.put(
                PaymentMode.UPI,
                new UpiPaymentProcessor(new RazorpayGateway())
        );

        processorMap.put(
                PaymentMode.CARD,
                new CardPaymentProcessor(new StripeGateway())
        );
    }

    public static PaymentProcessorFactory getInstance() {
        return INSTANCE;
    }

    public PaymentProcessor getProcessor(PaymentMode mode) {

        // Factory returns appropriate payment processor
        return processorMap.get(mode);
    }
}
