package ru.otus.java.pro;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MoneyBoxImpl implements MoneyBox {
    private int bills;
    private int denomination;

    @Override
    public int sum() {
        return bills * denomination;
    }


    @Override
    public int getMoney(int bills) {
        if (this.bills >= bills) {
            this.bills -= bills;
            return bills * denomination;
        } else {
            throw new RuntimeException("Банкомат не может выдать сумму");
        }
    }

    @Override
    public void putMoney(int bills) {
        this.bills += bills;
    }

}
