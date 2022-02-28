package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
@ToString
public class PhoneCategorize {
    @Setter
    @Getter
    private String country;
    @Setter
    @Getter
    private Boolean state;
    @Setter
    @Getter
    private String countryCode;
    @Setter
    @Getter
    private String number;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneCategorize that = (PhoneCategorize) o;
        return state == that.state &&
                country.equals(that.country) &&
                countryCode.equals(that.countryCode) &&
                number.equals(that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, state, countryCode, number);
    }
}
