package com.example.paymentdemo.service;

import com.example.paymentdemo.model.Customer;
import com.example.paymentdemo.model.Order;
import com.example.paymentdemo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderService orderService;

    public Customer getById(Integer customerId){
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        return customerOptional.orElse(null);
    }

    public void create(Customer newCustomer){
        customerRepository.save(newCustomer);
    }

    public void update(Integer oldCustomerId, Customer newCustomer){
        Customer updatedCustomer = this.getById(oldCustomerId);
        updatedCustomer.setFirstName(newCustomer.getFirstName());
        updatedCustomer.setLastName(newCustomer.getLastName());

        customerRepository.save(updatedCustomer);
    }

    public void delete(Integer customerId){
        customerRepository.delete(this.getById(customerId));
    }

    public void addNewOrder(Integer customerId, Order newOrder){
        Customer customer = this.getById(customerId);

        orderService.create(newOrder);
        newOrder.setCustomer(customer);

        customer.getOrders().add(newOrder);
        this.update(customerId, customer);
    }
}
