package com.java.Phase2.trial;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class GenericExample {
    public static void main(String[] args) {
        GenericClass<Integer> genericClass = new GenericClass<>(3);
        genericClass.printElement();

        List<Integer> list = Arrays.asList(1, 2, 3, 6, 4);
        genericClass.sort(list, Comparator.reverseOrder());
        System.out.println(list);

        genericClass.sort(list, Integer::compareTo);
        System.out.println(list);

        genericClass.sort(list, new Comparator<Integer>() {
            @Override public int compare(Integer o1, Integer o2) {
                return o1<o2 ? 1 : -1;
            }
        });
        System.out.println(list);
    }
}
