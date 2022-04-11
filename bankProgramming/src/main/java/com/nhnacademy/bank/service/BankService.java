package com.nhnacademy.bank.service;

import com.nhnacademy.bank.annotation.Deposit;
import com.nhnacademy.bank.annotation.Exchange;
import com.nhnacademy.bank.domain.Account;
import com.nhnacademy.bank.domain.Currency;
import com.nhnacademy.bank.domain.Money;
import com.nhnacademy.bank.exception.NegativeException;
import org.springframework.beans.factory.annotation.Autowired;

public class BankService {
    private final ExchangeService exchangeService;
    private final DepositService depositService;
    private WithdrawService withdrawService;

    public BankService(){
        this(null,null);
    }

    @Autowired
    public BankService(@Exchange ExchangeService exchangeService,
                       @Deposit DepositService depositService) {
        this.exchangeService = exchangeService;
        this.depositService = depositService;
    }

    public Money doExchange(Money money, Currency currency) throws NegativeException {
        return exchangeService.exchange(money, currency);
    }

    public void doDeposit(Account account, Money money) {
        this.depositService.deposit(account, money);
    }

    public void doWithdraw(Account account, Money money) {
        this.withdrawService.withdraw(account, money);
    }

    public void setWithdrawService(WithdrawService withdrawService) {
        this.withdrawService = withdrawService;
    }
}

