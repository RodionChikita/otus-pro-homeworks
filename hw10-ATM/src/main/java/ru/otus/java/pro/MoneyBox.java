package ru.otus.java.pro;




public interface MoneyBox {
    int sum();
    int getMoney(int bills) throws RuntimeException;
    void putMoney(int bills);
    int getDenomination();
    int getBills();
}
