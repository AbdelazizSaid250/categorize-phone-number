package com.example.demo.service.customer;

import com.example.demo.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer save(Customer customer);

    Customer delete(int id);

}
