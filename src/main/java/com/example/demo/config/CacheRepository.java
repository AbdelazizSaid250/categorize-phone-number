package com.example.demo.config;

import com.example.demo.model.Customer;
import com.example.demo.service.customer.CustomerService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
@Component
public class CacheRepository {
    private final CustomerService customerService;

    @Autowired
    public CacheRepository(CustomerService customerService) {
        log.info("I am in the CacheRepository Constructor!!");
        this.customerService = customerService;
    }

    @Getter
    private static List<Customer> customers = null;

    private void loadCustomers() {
        customers = customerService.findAll();
    }

    @PostConstruct
    public void init() {
        loadCustomers();
    }
}
