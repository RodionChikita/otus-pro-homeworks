package ru.otus.java.pro;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {
    private ArrayList<T> objects;

    public int weight() {
        int weight = 0;
        for (T object : objects) {
            weight += object.weight;
        }
        return weight;
    }


    public boolean compare(Box<?> anotherBox) {
        return this.weight() == anotherBox.weight();
    }

    public ArrayList<T> getBox() {
        return (ArrayList<T>) objects;
    }

    public void setBox(ArrayList<T> objects) {
        this.objects = objects;
    }

    public Box(T... objects) {
        this.objects = new ArrayList<>(Arrays.asList(objects));
    }
}
