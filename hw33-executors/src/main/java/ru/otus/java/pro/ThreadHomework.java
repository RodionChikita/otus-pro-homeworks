package ru.otus.java.pro;

import java.util.concurrent.BlockingQueue;

public class ThreadHomework extends Thread {
    BlockingQueue<String> in;
    BlockingQueue<String> out;

    public ThreadHomework(BlockingQueue<String> in, BlockingQueue<String> out){
        this.in = in;
        this.out = out;
    }

    @Override
    public void run() {
        for (int j = 0; j <= 3; j++) {
            for (int i = 1; i <= 10; i++) {
                try {
                    in.take();
                    System.out.println(Thread.currentThread().getName() + " Number: " + i);
                    out.put("your turn");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 9; i >= 1; i--) {
                try {
                    in.take();
                    System.out.println(Thread.currentThread().getName() + " Number: " + i);
                    out.put("your turn");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
