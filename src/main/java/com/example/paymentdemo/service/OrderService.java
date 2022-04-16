package com.example.paymentdemo.service;

import com.example.paymentdemo.model.Order;
import com.example.paymentdemo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PaymentService paymentService;

    public Order getById(Integer orderId){
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        return orderOptional.orElse(null);
    }

    public void create(Order newOrder){
        paymentService.create(newOrder);

        orderRepository.save(newOrder);
    }

    public void update(Integer oldOrderId, Order newOrder){
        Order updatedOrder = this.getById(oldOrderId);
        updatedOrder = newOrder;

        orderRepository.save(updatedOrder);
    }

    public void delete(Integer orderId){
        orderRepository.delete(this.getById(orderId));
    }
}
