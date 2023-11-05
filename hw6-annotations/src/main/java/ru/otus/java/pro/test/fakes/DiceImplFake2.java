package ru.otus.java.pro.test.fakes;

import ru.otus.java.pro.app.Dice;

public class DiceImplFake2 implements Dice {
        private boolean isFirstCall = true;
        @Override
        public int roll() {
            if(isFirstCall) {
                isFirstCall = false;
                return 6;
            }
            return 1;
        }
    }

