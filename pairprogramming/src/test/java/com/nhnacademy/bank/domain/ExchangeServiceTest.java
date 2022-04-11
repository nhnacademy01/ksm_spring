package com.nhnacademy.bank.domain;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import com.nhnacademy.bank.exception.NegativeException;
import java.math.BigDecimal;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExchangeServiceTest {
    //SUT
    ExchangeService exchangeService;

    @BeforeEach
    void setUp() {
        exchangeService = new ExchangeService();
    }

    @DisplayName("1,000원 -환전-> 1$")
    @Test
    void exchange_thousandWonToOneDollar() throws NegativeException {
        Money thousandWon = new Money(BigDecimal.valueOf(1_000L),"won");
        Money oneDollar = new Money(BigDecimal.valueOf(1),"dollar");

        Money result = exchangeService.exchange(thousandWon);
        assertThat(result.equals(oneDollar)).isTrue();
    }

    @Test
    void exchange_thousandWonToOneDollar_1() throws NegativeException {
        Money thousandWon = new Money(BigDecimal.valueOf(1_000L),"won");

        Money result = exchangeService.exchange(thousandWon);
        assertThat(result.getAmount()).isEqualTo(BigDecimal.valueOf(1));
    }

    @DisplayName("5.25$ -> 5,250원")
    @Test
    void exchange_decimalPointDollarToWon() throws NegativeException {
        Money amountWon = new Money(BigDecimal.valueOf(5_250L),"won");
        Money amountDollar = new Money(BigDecimal.valueOf(5.25),"dollar");

        Money result = exchangeService.exchange(amountDollar);
        assertThat(result.equals(amountWon)).isTrue();
    }

    @Test
    void exchange_decimalPointDollarToWon_1() throws NegativeException {
        Money amountDollar = new Money(BigDecimal.valueOf(5.25), "dollar");

        Money result = exchangeService.exchange(amountDollar);
        assertThat(result.getAmount()).isEqualTo(BigDecimal.valueOf(5_250L));
    }

    @DisplayName("달러 -> 원화: 5원 이상 -> 10원으로 반올림")
    @Test
    void exchange_rounds_dollarToWon() throws NegativeException {
        Money amountDollar1 = new Money(BigDecimal.valueOf(5.255),"dollar");
        Money amountDollar2 = new Money(BigDecimal.valueOf(5.256),"dollar");
        Money result1 = exchangeService.exchange(amountDollar1);
        Money result2 = exchangeService.exchange(amountDollar2);
        assertThat(result1.getAmount()).isEqualTo(BigDecimal.valueOf(5_260));
        assertThat(result2.getAmount()).isEqualTo(BigDecimal.valueOf(5_260));

    }

    @DisplayName("원화 -> 달러: $0.005 이상 -> $0.01 반올림")
    @Test
    void exchange_rounds_wonToDollar() throws NegativeException {
        Money amountWon1 = new Money(BigDecimal.valueOf(2_555),"won");
        Money amountWon2 = new Money(BigDecimal.valueOf(2_556),"won");

        Money result1 = exchangeService.exchange(amountWon1);
        Money result2 = exchangeService.exchange(amountWon2);
        assertThat(result1.getAmount()).isEqualTo(BigDecimal.valueOf(2.560));
        assertThat(result2.getAmount()).isEqualTo(BigDecimal.valueOf(2.560));
    }

    @AfterEach
    void tearDown() {
    }
}