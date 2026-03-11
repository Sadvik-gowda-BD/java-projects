package com.systemdesign.lld.paymentservice.service;

import com.systemdesign.lld.paymentservice.model.Payment;
import com.systemdesign.lld.paymentservice.model.PaymentRequest;
import com.systemdesign.lld.paymentservice.model.PaymentResponse;
import com.systemdesign.lld.paymentservice.repo.PaymentRepository;
import com.systemdesign.lld.paymentservice.service.processor.PaymentProcessor;


//PaymentService acts as orchestration layer coordinating processors, gateways and repository.
public class PaymentService {

    private PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public PaymentResponse processPayment(PaymentRequest request) {

        // Prevent duplicate payments using idempotency key
        // (not fully implemented here but conceptually checked)

        PaymentProcessor processor =
                PaymentProcessorFactory
                        .getInstance()
                        .getProcessor(request.getPaymentMode());

        PaymentResponse response = processor.pay(request);

        Payment payment = new Payment();

        paymentRepository.save(payment);

        return response;
    }
}
