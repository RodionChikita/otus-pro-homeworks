package ru.otus.java.pro.test.fakes;
import ru.otus.java.pro.app.Dice;

public class DiceImplFake1 implements Dice {
    @Override
    public int roll() {
        return 1;
    }
}