package com.example.demo.util;

import com.example.demo.model.Customer;
import com.example.demo.model.PhoneCategorize;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Slf4j
public class Utils {
    public static final String  CLOSE_PARENTHESES = "\\)";

    // lookup for countries
    public enum Countries {
        CAMERON("Cameroon", "+237", "\\(237\\)\\ ?[2368]\\d{7,8}$"),
        ETHIOPIA("Ethiopia", "+251", "\\(251\\)\\ ?[1-59]\\d{8}$"),
        MOROCCO("Morocco", "+212", "\\(212\\)\\ ?[5-9]\\d{8}$"),
        MOZAMBIQUE("Mozambique", "+258", "\\(258\\)\\ ?[5-9]\\d{8}$"),
        UGANDA("Uganda", "+256", "\\(256\\)\\ ?\\d{9}$");

        @Getter
        private final String name;
        @Getter
        private final String code;
        @Getter
        private final String regex;


        Countries(String name, String code, String regex) {
            this.name = name;
            this.code = code;
            this.regex = regex;
        }
    }


    public static List<PhoneCategorize> categorizeCustomers(List<Customer> customers) {
        List<PhoneCategorize> phoneCategorizes = new ArrayList<>();

        // Step 1: Iterate over the Customers which loaded from the Cache Repo.
        for (Customer customer : customers) {
            StringBuilder countryCode = new StringBuilder("+")
                    .append(customer.getPhone().split(Utils.CLOSE_PARENTHESES)[0].substring(1));
            String phoneNumber = customer.getPhone().split(Utils.CLOSE_PARENTHESES)[1].trim();

            // Step 2: Iterate over the lookup and check if customer phone code is equal to the lookup country phone code.
            for (Utils.Countries country : Utils.Countries.values()) {
                if (countryCode.toString().equals(country.getCode())) {
                    boolean isValid = Pattern.matches(country.getRegex(), customer.getPhone());

                    PhoneCategorize phoneCategorize = new PhoneCategorize();
                    phoneCategorize.setCountry(country.getName());
                    phoneCategorize.setCountryCode(country.getCode());
                    phoneCategorize.setState(isValid);
                    phoneCategorize.setNumber(phoneNumber);

                    // Step 3: Add the categorized object to the list that I will respond with it to the table.
                    phoneCategorizes.add(phoneCategorize);
                }
            }
        }
        return phoneCategorizes;
    }
}
