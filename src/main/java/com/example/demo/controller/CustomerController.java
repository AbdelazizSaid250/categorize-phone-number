package com.example.demo.controller;

import com.example.demo.config.CacheRepository;
import com.example.demo.model.Customer;
import com.example.demo.model.PhoneCategorize;
import com.example.demo.service.customer.CustomerService;
import com.example.demo.util.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Controller
@RequestMapping("customer")
public class CustomerController {

    /*private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        log.info("I am in the Customer Controller Constructor!!");
        this.customerService = customerService;
    }*/

    /*// for test only
    @GetMapping("list")
    private List<Customer> listAllCustomers() {
        List<Customer> customers = customerService.findAll();
        log.info("All Customers are: {}", customers);
        return customers;
    }

    // for test only
    @PostMapping("save")
    private Customer save(@RequestBody Customer customer) {
        log.info("Requested Customer is: {}", customer);
        Customer savedCustomer = customerService.save(customer);
        log.info("Inserted Customer is: {}", savedCustomer);

        return savedCustomer;
    }

    // for test only
    @DeleteMapping("delete/{id}")
    private Customer delete(@PathVariable int id) {
        Customer deletedCustomer = customerService.delete(id);
        log.info("Deleted Customer is: {}", deletedCustomer);

        return deletedCustomer;
    }*/

    @GetMapping("categorize")
    private String categorize(Model model, String country, String state) {
        List<Customer> customers = CacheRepository.getCustomers();
        log.info("All Customers are: {}", customers);

        List<PhoneCategorize> phoneCategorizes = Utils.categorizeCustomers(customers);
        log.info("Phones Categorization are: {}", phoneCategorizes);


        if (country == null && state == null) {
            model.addAttribute("phoneCategorize", phoneCategorizes);
        } else {
            List<PhoneCategorize> subPhoneCategorizes = new ArrayList<>();
            if (country != null && state != null) {
                phoneCategorizes.iterator()
                        .forEachRemaining(phoneCategorize -> {
                            if (phoneCategorize.getCountry().contains(country) &&
                                    phoneCategorize.getState().toString().contains(state)) {
                                subPhoneCategorizes.add(phoneCategorize);
                            }
                        });

                model.addAttribute("phoneCategorize", subPhoneCategorizes);
            }

            if (country != null && state == null) {
                phoneCategorizes.iterator()
                        .forEachRemaining(phoneCategorize -> {
                            if (phoneCategorize.getCountry().contains(country)) {
                                subPhoneCategorizes.add(phoneCategorize);
                            }
                        });

                model.addAttribute("phoneCategorize", subPhoneCategorizes);
            }

            if (country == null) {
                phoneCategorizes.iterator()
                        .forEachRemaining(phoneCategorize -> {
                            if (phoneCategorize.getState().toString().contains(state)) {
                                subPhoneCategorizes.add(phoneCategorize);
                            }
                        });

                model.addAttribute("phoneCategorize", subPhoneCategorizes);
            }

        }

        return "category";
    }

}
