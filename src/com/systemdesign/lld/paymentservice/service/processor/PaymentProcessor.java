package com.systemdesign.lld.paymentservice.service.processor;

import com.systemdesign.lld.paymentservice.model.PaymentRequest;
import com.systemdesign.lld.paymentservice.model.PaymentResponse;

//Strategy Pattern used
public interface PaymentProcessor {

    PaymentResponse pay(PaymentRequest request);

    // Strategy abstraction allowing different payment methods to implement their own logic
}
