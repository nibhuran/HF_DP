package com.java.Phase2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestParallelStream {
    public static void main(String[] args) {
        Date start = new Date();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        list.parallelStream().forEach(i -> sl());
        System.out.println("Parallel Stream\t: " + (System.currentTimeMillis() - start.getTime()));

        start = new Date();
        list.stream().forEach(i -> sl());
        System.out.println("Normal Stream\t: " + (System.currentTimeMillis() - start.getTime()));
    }

    private static void sl(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
