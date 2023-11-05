package ru.otus.java.pro.test.assertions;

import ru.otus.java.pro.app.Player;

public class Assertions {
    public static void assertEquals( Player expected, Player actual) {
        if (!expected.equals(actual)) {
            throw new AssertionError(String.format("Expected \"%s\" = \"%s\"", expected, actual));
        }
    }
}
