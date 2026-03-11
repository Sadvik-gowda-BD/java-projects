package com.systemdesign.lld.paymentservice;

import com.systemdesign.lld.paymentservice.model.PaymentMode;
import com.systemdesign.lld.paymentservice.model.PaymentRequest;
import com.systemdesign.lld.paymentservice.model.PaymentResponse;
import com.systemdesign.lld.paymentservice.repo.InMemoryPaymentRepository;
import com.systemdesign.lld.paymentservice.repo.PaymentRepository;
import com.systemdesign.lld.paymentservice.service.PaymentService;

public class Main {

    public static void main(String[] args) {

        PaymentRepository repo = new InMemoryPaymentRepository();

        PaymentService paymentService = new PaymentService(repo);

        PaymentRequest request = new PaymentRequest();

        request.setOrderId("ORDER123");
        request.setAmount(500);
        request.setPaymentMode(PaymentMode.UPI);

        PaymentResponse response =
                paymentService.processPayment(request);

        System.out.println(response.getStatus());
    }
}