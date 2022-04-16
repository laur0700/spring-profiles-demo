package com.example.paymentdemo.model;

import com.example.paymentdemo.enums.PaymentMethod;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "payments")
@Data
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private PaymentMethod paymentMethod;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    private Order order;
}
