package ru.otus.java.pro.API;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.otus.java.pro.cashmachine.machine.data.CashMachine;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ATMRequest {

    private String cardNum;
    private String pin;
    private BigDecimal amount;
    private int count5000;
    private int count1000;
    private int count500;
    private int count100;
    private CashMachine machine;
    private String newPin;

    public List<Integer> counter(){
        return List.of(count5000, count1000, count500, count100);
    }
}