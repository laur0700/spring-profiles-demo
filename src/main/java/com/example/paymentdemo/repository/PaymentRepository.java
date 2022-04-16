package com.example.paymentdemo.repository;

import com.example.paymentdemo.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
