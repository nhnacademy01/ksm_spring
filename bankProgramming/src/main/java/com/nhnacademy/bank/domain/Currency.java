package com.nhnacademy.bank.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Currency {
    String value;
    BigDecimal rate;

    public Currency(String value){
        this(value,null);
    }

    public Currency(String value, BigDecimal rate) {
        this.value = value;
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Currency currency = (Currency) o;
        return Objects.equals(value, currency.value) &&
            Objects.equals(rate, currency.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, rate);
    }

    public String getValue() {
        return this.value;
    }

    public BigDecimal getRate() {
        return this.rate;
    }
}
