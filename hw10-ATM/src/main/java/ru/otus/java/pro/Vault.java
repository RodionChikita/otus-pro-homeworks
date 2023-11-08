package ru.otus.java.pro;

import java.util.List;

public interface Vault {
    void getMoney(int sum);
    int sum();
    void putMoney(List<Integer> bills);
}
