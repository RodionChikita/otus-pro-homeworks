package ru.otus.java.pro;

import java.util.List;

public interface VaultService {
    void getMoney(int sum);

    int sum();

    void putMoney(List<Integer> bills);
}
