package ru.otus.java.pro;


import java.math.BigDecimal;


public interface MoneyBox {
    public int sum();

    public int getMoney(int bills) throws RuntimeException;
    public void putMoney(int bills);
    public int getDenomination();
    public int getBills();
}
