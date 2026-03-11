package com.systemdesign.lld.paymentservice.service.gateway;

import com.systemdesign.lld.paymentservice.model.PaymentRequest;
import com.systemdesign.lld.paymentservice.model.PaymentResponse;

public class RazorpayGateway implements PaymentGateway {

    //Integrates with Razorpay APIs and translates response to internal payment response
    @Override
    public PaymentResponse charge(PaymentRequest request) {
        // call Razorpay REST API
        return new PaymentResponse();
    }
}
