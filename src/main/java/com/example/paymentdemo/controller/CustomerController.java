package com.example.paymentdemo.controller;

import com.example.paymentdemo.model.Customer;
import com.example.paymentdemo.model.Order;
import com.example.paymentdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("get/id/{id}")
    public Customer getById(@PathVariable Integer id){
        return customerService.getById(id);
    }

    @PostMapping("create")
    public void create(@RequestBody Customer newCustomer){
        customerService.create(newCustomer);
    }

    @PostMapping("update/id/{id}")
    public void update(@PathVariable Integer id, @RequestBody Customer newCustomer){
        customerService.update(id, newCustomer);
    }

    @DeleteMapping("delete/id/{id}")
    public void delete(@PathVariable Integer id){
        customerService.delete(id);
    }

    @PostMapping("add-order/id/{id}")
    public void addNewOrder(@PathVariable Integer id, @RequestBody Order newOrder){
        customerService.addNewOrder(id, newOrder);
    }
}
