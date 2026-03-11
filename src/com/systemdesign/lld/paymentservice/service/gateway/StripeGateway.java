package com.systemdesign.lld.paymentservice.service.gateway;

import com.systemdesign.lld.paymentservice.model.PaymentRequest;
import com.systemdesign.lld.paymentservice.model.PaymentResponse;

public class StripeGateway implements PaymentGateway {

    @Override
    public PaymentResponse charge(PaymentRequest request) {

        // Integrates with Stripe APIs and adapts their response

        return new PaymentResponse();
    }
}
