package ru.otus.java.pro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> objects;


    public int weight() {
        int weight = 0;
        for (T object : objects) {
            weight += object.weight;
        }
        return weight;
    }

    public void pourer(Box<? super T> anotherBox){
        for (T object: this.objects) {
            anotherBox.objects.add(object);
        }
        this.objects.clear();
    }

    public void addObject(T object){
        this.objects.add(object);
    }


    public boolean compare ( Box<? extends Fruit> anotherBox) {
        if (anotherBox != null) {
            return this.weight() == anotherBox.weight();
        }else {
            return false;
        }
    }

    public List<T> getBox() {
        return objects;
    }

    @SafeVarargs
    public Box(T... objects) {
        this.objects = new ArrayList<>(Arrays.asList(objects));
    }
}
