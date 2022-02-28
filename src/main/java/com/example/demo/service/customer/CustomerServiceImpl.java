package com.example.demo.service.customer;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        log.info("I am in the Customer Service Impl Constructor!!");
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer delete(int id) {
        Optional<Customer> foundCustomer = customerRepository.findById(id);
        if (foundCustomer.isPresent()) {
            customerRepository.delete(foundCustomer.get());
        } else {
            log.error("didn't find the Customer in the server.");
            throw new RuntimeException("We didn't find the Customer");
        }
        return foundCustomer.get();
    }
}
