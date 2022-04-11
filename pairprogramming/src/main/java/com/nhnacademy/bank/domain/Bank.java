package com.nhnacademy.bank.domain;

import com.nhnacademy.bank.exception.NegativeException;

public class Bank {
    private final ExchangeService exchangeService;

    public Bank(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    public Money doExchange(Money money) throws NegativeException {
        return exchangeService.exchange(money);
    }
}

