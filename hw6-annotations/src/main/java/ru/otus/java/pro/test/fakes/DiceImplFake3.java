package ru.otus.java.pro.test.fakes;

import ru.otus.java.pro.app.Dice;

public class DiceImplFake3 implements Dice {
    private boolean isFirstCall = true;
    @Override
    public int roll() {
        if(isFirstCall) {
            isFirstCall = false;
            return 1;
        }
        return 6;
    }
}
