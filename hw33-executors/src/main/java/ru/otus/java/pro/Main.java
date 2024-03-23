package ru.otus.java.pro;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> t1t2 = new LinkedBlockingQueue<>(1);
        BlockingQueue<String> t2t1 = new LinkedBlockingQueue<>(1);
        new ThreadHomework(t1t2, t2t1).start();
        new ThreadHomework(t2t1, t1t2).start();
        t1t2.put("Start");
    }
}