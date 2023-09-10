package ru.otus.java.pro;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> box;

    public ArrayList<T> getBox() {
        return box;
    }
}
