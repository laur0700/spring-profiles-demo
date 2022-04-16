package com.example.paymentdemo.service;

import com.example.paymentdemo.enums.PaymentMethod;
import com.example.paymentdemo.model.Order;
import com.example.paymentdemo.model.Payment;
import com.example.paymentdemo.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class DevPaymentService implements PaymentService{
    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public void create(Order order){
        Payment newPayment = new Payment();

        if(order.getAmount() > 100)
            newPayment.setPaymentMethod(PaymentMethod.DEV_CARD);
        else
            newPayment.setPaymentMethod(PaymentMethod.DEV_CASH);

        newPayment.setOrder(order);
        order.setPayment(newPayment);

        paymentRepository.save(newPayment);
    }
}
