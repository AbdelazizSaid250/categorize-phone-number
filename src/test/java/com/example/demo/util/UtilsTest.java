package com.example.demo.util;

import com.example.demo.model.Customer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {
    @Test
    void testCategorizeEmptyCustomers() {
        assertTrue(Utils.categorizeCustomers(new ArrayList<>()).isEmpty());
    }

    @Test
    void testCategorizeValidCustomers() {
        List<Customer> customers = new ArrayList<>(
                Collections.singletonList(new Customer(100, "Abdelaziz", "(212) 698054317"))
        );

        assertEquals(Utils.categorizeCustomers(customers).get(0).getCountry(), Utils.Countries.MOROCCO.getName());
        assertEquals(Utils.categorizeCustomers(customers).get(0).getCountryCode(), Utils.Countries.MOROCCO.getCode());
        assertEquals(Utils.categorizeCustomers(customers).get(0).getNumber(), "698054317");
        assertTrue(Utils.categorizeCustomers(customers).get(0).getState(), "This Phone number is a right Moroccan number!!");
    }

    @Test
    void testCategorizeNonValidCustomers() {
        List<Customer> customers = new ArrayList<>(
                Collections.singletonList(new Customer(100, "Abdelaziz", "(212) 123"))
        );

        assertEquals(Utils.categorizeCustomers(customers).get(0).getCountry(), Utils.Countries.MOROCCO.getName());
        assertEquals(Utils.categorizeCustomers(customers).get(0).getCountryCode(), Utils.Countries.MOROCCO.getCode());
        assertEquals(Utils.categorizeCustomers(customers).get(0).getNumber(), "123");
        assertFalse(Utils.categorizeCustomers(customers).get(0).getState(), "This Phone number is not a right Moroccan number!!");
    }
}

