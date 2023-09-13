package ru.otus.java.pro;


public class Main {
    public static void main(String[] args) {
        Apple apple1 = new Apple(1);
        Apple apple2 = new Apple(2);
        Apple apple3 = new Apple(3);
        Apple apple4 = new Apple(4);

        Orange orange1 = new Orange(1);
        Orange orange2 = new Orange(2);
        Orange orange3 = new Orange(3);
        Orange orange4 = new Orange(4);

        Box<Apple> boxApple = new Box<>(apple1, apple2);
        Box<Apple> boxApple1 = new Box<>(apple3, apple4);
        Box<Orange> boxOrange = null;
        Box<Fruit> boxFruit = new Box<>(apple1, orange2);

        System.out.println(boxApple.getBox());
        System.out.println(boxFruit.getBox());
        System.out.println(boxApple.weight());
        System.out.println(boxFruit.weight());
        System.out.println(boxApple.compare(boxFruit));
        boxApple.pourer(boxFruit);
        System.out.println(boxFruit.getBox());
    }
}