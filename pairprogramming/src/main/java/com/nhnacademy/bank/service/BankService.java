package com.nhnacademy.bank.service;

import com.nhnacademy.bank.domain.Currency;
import com.nhnacademy.bank.exception.NegativeException;
import com.nhnacademy.bank.domain.Bank;
import com.nhnacademy.bank.domain.Money;
import java.math.BigDecimal;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BankService {
    public static void main(String[] args) throws NegativeException {
        Money manWon = new Money(BigDecimal.valueOf(10_000L),new Currency("won"));
        Money tenEuro = new Money(BigDecimal.valueOf(15L), new Currency("euro",BigDecimal.valueOf(1_300L)));
        try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")){
            Bank bank = context.getBean("bank",Bank.class);
            Money exchangeManWon = bank.doExchange(manWon, new Currency("dollar", BigDecimal.valueOf(1_000L)));
            Money exchangeTenEuro = bank.doExchange(tenEuro, new Currency("won"));
            System.out.println("10,000원 달러로 환전: "+exchangeManWon.getAmount()+exchangeManWon.getCurrency().getValue());
            System.out.println("15유로 원화로 환전: "+exchangeTenEuro.getAmount()+exchangeTenEuro.getCurrency().getValue());
        }
    }
}
