package ru.otus.java.pro.test.fakes;

import ru.otus.java.pro.app.GameWinnerPrinter;
import ru.otus.java.pro.app.Player;

import java.util.List;

public class GameWinnerConsolePrinterFake implements GameWinnerPrinter {
    private final List<Player> actualFlow;

    public GameWinnerConsolePrinterFake(List<Player> actualFlow) {
        this.actualFlow = actualFlow;
    }

    @Override
    public void printWinner(Player winner) {

        actualFlow.add(winner);
    }
}
