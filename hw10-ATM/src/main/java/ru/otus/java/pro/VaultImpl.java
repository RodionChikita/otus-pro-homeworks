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
public class VaultImpl implements Vault {
    private List<MoneyBox> moneyBoxes;

    @Override
    public void getMoney(int sum) {
        final int INFINITY = 2147483646;
        int[] F = new int[sum + 1];
        F[0] = 0;
        int m, i;
        int k = moneyBoxes.size();
        int[] denominations = new int[k];
        int[] bills = new int[k];
        for (i = 0; i < k; i++) {
            denominations[i] = moneyBoxes.get(i).getDenomination();
            bills[i] = moneyBoxes.get(i).getBills();
        }

        for (m = 1; m <= sum; ++m) {
            F[m] = INFINITY;
            for (i = 0; i < k; ++i) {
                if (m >= denominations[i] && F[m - denominations[i]] + 1 < F[m]) {
                    F[m] = F[m - denominations[i]] + 1;
                }
            }
        }
        System.out.println(F[sum]);
        try {
            if (F[sum] == INFINITY) {
                throw new RuntimeException();
            } else {
                int[] billsToGet = new int[k];
                while (sum > 0) {
                    for (i = 0; i < k; ++i) {
                        if (F[sum - denominations[i]] == F[sum] - 1) {
                            billsToGet[i]++;
                            System.out.println(denominations[i]);
                            sum -= denominations[i];
                            break;
                        }
                    }
                }
                for(i = 0; i < k; i++){
                    if(billsToGet[i] > bills[i]){
                        throw new RuntimeException("Банкомат не может выдать сумму");
                    }
                }
                for(i = 0; i < k; i++){
                    moneyBoxes.get(i).getMoney(billsToGet[i]);
                }
            }

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
        for (MoneyBox moneyBox : moneyBoxes) {
            for (Integer bill : bills) {
                if (bill == moneyBox.getDenomination()) {
                    moneyBox.putMoney(1);
                    bills.remove(bill);
                }
            }
        }
        if (!bills.isEmpty()) {
            throw new RuntimeException();
        }
    }
}
