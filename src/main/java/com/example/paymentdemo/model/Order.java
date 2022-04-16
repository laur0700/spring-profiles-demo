package com.example.paymentdemo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int amount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Payment payment;

}
