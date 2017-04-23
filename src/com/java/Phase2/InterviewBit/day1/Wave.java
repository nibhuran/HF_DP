package com.java.Phase2.InterviewBit.day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Wave {

    public static void main(String[] args) {
        Integer[] array = {5, 1, 3, 2, 4};
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(array));

        System.out.println(wave(a));
    }


    private static ArrayList<Integer> wave(ArrayList<Integer> a) {
        Collections.sort(a);
        for (int i = 0; i < a.size();) {
            if(i + 1 < a.size()){
                int temp = a.get(i);
                a.set(i, a.get(i+1));
                a.set(i+1, temp);
                i = i + 2;
            } else {
                break;
            }
        }
        return a;
    }
}
