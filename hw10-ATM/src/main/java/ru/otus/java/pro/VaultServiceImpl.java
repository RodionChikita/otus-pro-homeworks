package ru.otus.java.pro;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VaultServiceImpl implements VaultService {
    private List<MoneyBox> moneyBoxes;

    @Override
    public void getMoney(int sum) {
        final int INFINITY = 2147483646;
        int denominationsQuantity = moneyBoxes.size();
        int[] waysToPayAmount = new int[sum + 1];
        int[] denominations = new int[denominationsQuantity];
        int[] bills = new int[denominationsQuantity];
        for (int i = 0; i < denominationsQuantity; i++) {
            denominations[i] = moneyBoxes.get(i).getDenomination();
            bills[i] = moneyBoxes.get(i).getBills();
        }
        searchingMinQuantityOfBills(waysToPayAmount, sum, denominationsQuantity, denominations, INFINITY);
        try {
            amountIssue(waysToPayAmount, sum, denominationsQuantity, denominations, INFINITY, bills);

        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
        }
    }


    @Override
    public int sum() {
        int sum = 0;
        for (MoneyBox moneyBox : moneyBoxes) {
            sum += moneyBox.sum();
        }
        return sum;
    }

    @Override
    public void putMoney(List<Integer> bills) {
        int billsDeposited = 0;
        try {
            for (MoneyBox moneyBox : moneyBoxes) {
                for (Integer bill : bills) {
                    if (bill == moneyBox.getDenomination()) {
                        moneyBox.putMoney(1);
                        billsDeposited++;
                    }
                }
            }
            if (billsDeposited != bills.size()) {
                throw new RuntimeException("Не все купюры приняты");
            }
        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void searchingMinQuantityOfBills(int[] waysToPayAmount, int sum, int denominationsQuantity, int[] denominations, int INFINITY) {
        int amountToPay;
        waysToPayAmount[0] = 0;
        for (amountToPay = 1; amountToPay <= sum; ++amountToPay) {
            waysToPayAmount[amountToPay] = INFINITY;
            for (int i = 0; i < denominationsQuantity; ++i) {
                if (amountToPay >= denominations[i] && waysToPayAmount[amountToPay - denominations[i]] + 1 < waysToPayAmount[amountToPay]) {
                    waysToPayAmount[amountToPay] = waysToPayAmount[amountToPay - denominations[i]] + 1;
                }
            }
        }
    }

    private void amountIssue(int[] waysToPayAmount, int sum, int denominationsQuantity, int[] denominations, int INFINITY, int[] bills) {
        if (waysToPayAmount[sum] == INFINITY) {
            throw new RuntimeException("Не возможно выдать сумму имеющимися номиналами");
        } else {
            int[] billsToGet = billsToGetAmount(waysToPayAmount, sum, denominationsQuantity, denominations);
            for (int i = 0; i < denominationsQuantity; i++) {
                if (billsToGet[i] > bills[i]) {
                    throw new RuntimeException("Банкомат не может выдать сумму");
                }
            }
            for (int i = 0; i < denominationsQuantity; i++) {
                moneyBoxes.get(i).getMoney(billsToGet[i]);
            }
        }
    }
    private int[] billsToGetAmount(int[] waysToPayAmount, int sum, int denominationsQuantity, int[] denominations){
        int[] billsToGet = new int[denominationsQuantity];
        while (sum > 0) {
            for (int i = 0; i < denominationsQuantity; ++i) {
                if (waysToPayAmount[sum - denominations[i]] == waysToPayAmount[sum] - 1) {
                    billsToGet[i]++;
                    System.out.println(denominations[i]);
                    sum -= denominations[i];
                    break;
                }
            }
        }
        return billsToGet;
    }
}
