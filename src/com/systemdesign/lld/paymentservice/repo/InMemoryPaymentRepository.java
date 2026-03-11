package com.systemdesign.lld.paymentservice.repo;

import com.systemdesign.lld.paymentservice.model.Payment;

public class InMemoryPaymentRepository implements PaymentRepository{
    @Override
    public void save(Payment payment) {

    }

    @Override
    public Payment findById(String paymentId) {
        return null;
    }
}
