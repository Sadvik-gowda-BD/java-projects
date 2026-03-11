package com.systemdesign.lld.paymentservice.repo;

import com.systemdesign.lld.paymentservice.model.Payment;

public interface PaymentRepository {

    void save(Payment payment);

    Payment findById(String paymentId);

    // Repository abstraction separates persistence logic from business logic
}
