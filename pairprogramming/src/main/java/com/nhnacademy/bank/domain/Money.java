package com.nhnacademy.bank.domain;

import com.nhnacademy.bank.exception.DifferentCurrencyException;
import com.nhnacademy.bank.exception.ImpossibleSubtractException;
import com.nhnacademy.bank.exception.NegativeException;
import java.math.BigDecimal;
import java.util.Objects;

public class Money {
    private final String currency;
    private BigDecimal amount;

    public Money(BigDecimal amount, String currency) throws NegativeException {
        if (isSmallerThan(amount)) {
            throw new NegativeException("Number is negative");
        }
        this.amount = amount;
        this.currency = currency;
    }

    public Money add(Money money) throws NegativeException, DifferentCurrencyException {
        if (isEqualCurrency(money)) {
            throw new DifferentCurrencyException("different currency");
        }
        return new Money(this.amount.add(money.getAmount()), "dollar");
    }

    public void sub(Money money) throws ImpossibleSubtractException {
        if (isSmallerThan(money)) {
            throw new ImpossibleSubtractException("impossible subtract");
        }
        // TODO: sub 구현
    }

    private boolean isSmallerThan(BigDecimal amount) {
        return amount.compareTo(BigDecimal.ZERO) == -1;
    }

    private boolean isSmallerThan(Money money) {
        return this.amount.compareTo(money.getAmount()) == -1;
    }

    private boolean isEqualCurrency(Money money) {
        return !(this.currency.equals(money.getCurrency()));
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        Money money = (Money) o;
        return Objects.equals(amount, money.getAmount());
    }
}