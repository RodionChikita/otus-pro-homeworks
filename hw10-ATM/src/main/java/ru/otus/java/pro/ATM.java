package ru.otus.java.pro;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class ATM {
    public static void main(String[] args) {
        Logger log = Logger.getLogger(ATM.class.getName());
        MoneyBox moneyBox1 = new MoneyBoxImpl(10, 100);
        MoneyBox moneyBox2 = new MoneyBoxImpl(10, 200);
        MoneyBox moneyBox3 = new MoneyBoxImpl(10, 500);
        MoneyBox moneyBox4 = new MoneyBoxImpl(10, 1000);
        log.info(String.valueOf(moneyBox1.sum()));

        VaultService vault = new VaultServiceImpl(Arrays.asList(moneyBox1, moneyBox2, moneyBox3, moneyBox4));
        log.info(String.valueOf(vault.sum()));
        vault.getMoney(19000);
        log.info(String.valueOf(moneyBox4.getBills()));
        log.info(String.valueOf(vault.sum()));
        vault.putMoney(List.of(10, 1000, 500, 200));
        log.info(String.valueOf(vault.sum()));
    }
}