package com.nhnacademy.bank.domain;

import com.nhnacademy.bank.exception.DifferentCurrencyException;
import com.nhnacademy.bank.exception.ImpossibleSubtractException;
import com.nhnacademy.bank.exception.NegativeException;
import java.math.BigDecimal;
import java.util.Objects;

public class Money {
    private final Currency currency;
    private final BigDecimal amount;

    public Money(BigDecimal amount, Currency currency) throws NegativeException {
        if (isSmallerThan(amount)) {
            throw new NegativeException("Number is negative");
        }
        this.amount = amount;
        this.currency = currency;
    }

    public Money add(Money money) throws NegativeException, DifferentCurrencyException {
        if (isDifferentCurrency(money)) {
            throw new DifferentCurrencyException("different currency");
        }
        return new Money(this.amount.add(money.getAmount()), this.currency);
    }

    public Money sub(Money money) throws ImpossibleSubtractException, NegativeException {
        if (isSmallerThan(money)) {
            throw new ImpossibleSubtractException("impossible subtract");
        }
        return new Money(this.amount.subtract(money.getAmount()),this.currency);
    }

    private boolean isSmallerThan(BigDecimal amount) {
        return amount.compareTo(BigDecimal.ZERO) == -1;
    }

    private boolean isSmallerThan(Money money) {
        return this.amount.compareTo(money.getAmount()) == -1;
    }

    private boolean isDifferentCurrency(Money money) {
        return !(this.currency.equals(money.getCurrency()));
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money = (Money) o;
        return currency.equals(money.currency) && amount.equals(money.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, amount);
    }
}