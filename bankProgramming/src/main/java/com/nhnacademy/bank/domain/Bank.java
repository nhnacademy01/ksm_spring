package com.nhnacademy.bank.domain;

import com.nhnacademy.bank.annotation.Deposit;
import com.nhnacademy.bank.annotation.Exchange;
import com.nhnacademy.bank.annotation.Withdraw;
import com.nhnacademy.bank.exception.NegativeException;
import org.springframework.beans.factory.annotation.Autowired;

public class Bank {
    private final ExchangeService exchangeService;
    private final DepositService depositService;
    private WithdrawService withdrawService;

    public Bank(){
        this(null,null);
    }

    @Autowired
    public Bank(@Exchange ExchangeService exchangeService,
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

