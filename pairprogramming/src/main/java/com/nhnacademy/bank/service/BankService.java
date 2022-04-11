package com.nhnacademy.bank.service;

import com.nhnacademy.bank.exception.NegativeException;
import com.nhnacademy.bank.domain.Bank;
import com.nhnacademy.bank.domain.Money;
import java.math.BigDecimal;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BankService {
    public static void main(String[] args) throws NegativeException {
        Money money = new Money(BigDecimal.valueOf(10_000L),"won");

        try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")){
            Money exchangeMoney = context.getBean("bank", Bank.class).doExchange(money);
            System.out.println(exchangeMoney.getAmount()+exchangeMoney.getCurrency());
        }
    }
}
