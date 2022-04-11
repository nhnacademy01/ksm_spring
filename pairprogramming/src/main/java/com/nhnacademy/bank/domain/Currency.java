package com.nhnacademy.bank.domain;

import java.math.BigDecimal;

public class Currency {
    String value;
    BigDecimal rate;

    public Currency(String value, BigDecimal rate) {
        this.value = value;
        this.rate = rate;
    }
}
