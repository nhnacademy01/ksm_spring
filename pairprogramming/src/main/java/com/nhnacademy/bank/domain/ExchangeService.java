package com.nhnacademy.bank.domain;

import com.nhnacademy.bank.exception.NegativeException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ExchangeService {
    public Money exchange(Money money) throws NegativeException {
        if (money.getCurrency().equals(new Currency("dollar",BigDecimal.valueOf(10_000L)))) {
            BigDecimal rate = money.getCurrency().getRate();
            BigDecimal exchangeAmt =
                money.getAmount().multiply(rate).setScale(0);
            return new Money(roundsExchangeAmt(exchangeAmt), new Currency("won"));
        }
        if (money.getCurrency().equals(new Currency("won"))) {
            BigDecimal exchangeAmt = money.getAmount().divide(BigDecimal.valueOf(1_000));
            exchangeAmt = exchangeAmt.setScale(2, RoundingMode.HALF_UP);
            return new Money(setScaleZeroWhenInt(exchangeAmt), new Currency("dollar",BigDecimal.valueOf(1_000L)));
        }
        return null;
    }

    int checkExchangeAmt(BigDecimal exchangeAmt) {
        return exchangeAmt.remainder(BigDecimal.valueOf(10)).compareTo(BigDecimal.valueOf(5));
    }

    BigDecimal roundsExchangeAmt(BigDecimal exchangeAmt) {
        int checkStandard = checkExchangeAmt(exchangeAmt);
        if (checkStandard == 0 || checkStandard == 1) {
            BigDecimal difference =
                BigDecimal.valueOf(10).subtract(exchangeAmt.remainder(BigDecimal.valueOf(10)));
            return exchangeAmt.add(difference);
        }
        return exchangeAmt;
    }

    BigDecimal setScaleZeroWhenInt(BigDecimal exchangeAmt) {
        BigDecimal a = exchangeAmt.setScale(0, RoundingMode.FLOOR);
        if (exchangeAmt.compareTo(a) == 0) {
            return exchangeAmt.setScale(0);
        }
        return exchangeAmt;
    }
}
