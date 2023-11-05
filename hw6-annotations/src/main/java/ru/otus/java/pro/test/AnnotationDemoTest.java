package ru.otus.java.pro.test;

import ru.otus.java.pro.After;
import ru.otus.java.pro.Before;
import ru.otus.java.pro.Test;
import ru.otus.java.pro.app.Game;
import ru.otus.java.pro.app.Player;
import ru.otus.java.pro.test.assertions.Assertions;
import ru.otus.java.pro.test.fakes.DiceImplFake1;
import ru.otus.java.pro.test.fakes.DiceImplFake2;
import ru.otus.java.pro.test.fakes.DiceImplFake3;
import ru.otus.java.pro.test.fakes.GameWinnerConsolePrinterFake;

import java.util.ArrayList;

public class AnnotationDemoTest {
    @Before
    public void beforeMethod(){
        System.out.println("before");
    }

    @Test
    public void testGameWithNoWinner () {
        String scenario = "Тест на ничью";
        DiceImplFake1 diceImplFake1 = new DiceImplFake1();
        ArrayList<Player> actualFlow = new ArrayList<>();
        GameWinnerConsolePrinterFake winnerPrinter = new GameWinnerConsolePrinterFake(actualFlow) ;
        Game game1 = new Game(diceImplFake1, winnerPrinter);
        try {
            Player player1 = new Player("Player 1");
            Player player2 = new Player("Player 2");
            game1.playGame(player1, player2);
            Assertions.assertEquals(null, actualFlow.get(0));

            System.out.printf("\"%s\" passed %n", scenario);

        } catch (Throwable e) {
            throw new IllegalArgumentException(String.format("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage()));
        }
    }

    @Test
    public void testGameWithWinnerPlayer1 () {
        String scenario = "Тест победил первый игрок";
        DiceImplFake2 diceImplFake2= new DiceImplFake2();
        ArrayList<Player> actualFlow = new ArrayList<>();
        GameWinnerConsolePrinterFake winnerPrinter = new GameWinnerConsolePrinterFake(actualFlow);
        Game game2 = new Game(diceImplFake2, winnerPrinter);
        try {
            Player player1 = new Player("Player 1");
            Player player2 = new Player("Player 2");
            game2.playGame(player1, player2);
            Assertions.assertEquals(player1, actualFlow.get(0));

            System.out.printf("\"%s\" passed %n", scenario);

        } catch (Throwable e) {
            throw new IllegalArgumentException(String.format("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage()));
        }
    }

    @Test
    public void testGameWithWinnerPlayer2() {
        String scenario = "Тест победил второй игрок";
        DiceImplFake3 diceImplFake3 = new DiceImplFake3();
        ArrayList<Player> actualFlow = new ArrayList<>();
        GameWinnerConsolePrinterFake winnerPrinter = new GameWinnerConsolePrinterFake(actualFlow) ;
        Game game3= new Game(diceImplFake3, winnerPrinter);
        try {
            Player player1 = new Player("Player 1");
            Player player2 = new Player("Player 2");
            game3.playGame(player1, player2);
            Assertions.assertEquals(player2, actualFlow.get(0));

            System.out.printf("\"%s\" passed %n", scenario);

        } catch (Throwable e) {
            throw new IllegalArgumentException(String.format("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage()));
        }
    }

        @After
    public void afterMethod(){
            System.out.println("after");
    }
}
