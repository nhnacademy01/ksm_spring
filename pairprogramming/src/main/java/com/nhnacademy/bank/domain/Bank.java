package com.nhnacademy.bank.domain;

import com.nhnacademy.bank.annotation.Exchange;
import com.nhnacademy.bank.exception.NegativeException;
import org.springframework.beans.factory.annotation.Autowired;

public class Bank {
    private final ExchangeService exchangeService;

    @Autowired
    public Bank(@Exchange ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    public Money doExchange(Money money) throws NegativeException {
        return exchangeService.exchange(money);
    }
}

