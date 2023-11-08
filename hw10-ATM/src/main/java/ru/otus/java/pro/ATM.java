package ru.otus.java.pro;

import java.util.Arrays;
import java.util.List;

public class ATM {
    public static void main(String[] args) {
        MoneyBox moneyBox1 = new MoneyBoxImpl(10, 100);
        MoneyBox moneyBox2 = new MoneyBoxImpl(10, 200);
        MoneyBox moneyBox3 = new MoneyBoxImpl(10, 500);
        MoneyBox moneyBox4 = new MoneyBoxImpl(10, 1000);
        System.out.println(moneyBox1.sum());

        Vault vault = new VaultImpl(Arrays.asList(moneyBox1, moneyBox2, moneyBox3, moneyBox4));
        System.out.println(vault.sum());
        vault.getMoney(19000);
        System.out.println(moneyBox4.getBills());
        System.out.println(vault.sum());
        vault.putMoney(List.of(10,1000,500,200));
        System.out.println(vault.sum());
    }
}