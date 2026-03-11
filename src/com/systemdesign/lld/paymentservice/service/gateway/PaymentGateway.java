package com.systemdesign.lld.paymentservice.service.gateway;

import com.systemdesign.lld.paymentservice.model.PaymentRequest;
import com.systemdesign.lld.paymentservice.model.PaymentResponse;

//Different payment providers have different APIs. Gateway abstraction hides those differences.
//Adapter design pattern
public interface PaymentGateway {

    PaymentResponse charge(PaymentRequest request);
    // Adapter abstraction to support multiple external payment providers
}

/*
Adapter design pattern:
Client → Target Interface → Adapter → Adaptee

Client = PaymentService
Target Interface = PaymentGateway
Adapter = RazorpayGateway / StripeGateway
Adaptee = RazorpayAPI / StripeAPI

Payment providers expose different APIs. The PaymentGateway interface acts as a common abstraction, and concrete
classes like RazorpayGateway or StripeGateway adapt those provider APIs to our internal interface. This allows our
system to interact with different payment providers without changing business logic.

 */
