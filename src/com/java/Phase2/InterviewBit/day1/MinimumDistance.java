package com.java.Phase2.InterviewBit.day1;

import java.util.ArrayList;
import java.util.Arrays;

public class MinimumDistance {
    public static void main(String[] args) {
        Integer[] array = {3, 19};
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(array));
        Integer[] array2 = {6, 13};
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(array2));

        System.out.println(coverPoints(a,b));
    }


    // X and Y co-ordinates of the points in order.
    // Each point is represented by (X.get(i), Y.get(i))
    private static int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        int result = 0;
        if(X.size() < 2){
            return result;
        }
        for (int i = 1; i < X.size(); i++) {
            int a = Math.abs(X.get(i) - X.get(i-1));
            int b = Math.abs(Y.get(i) - Y.get(i-1));
            int diff = Math.max(a, b);
            result = result + (diff);
        }
        return result;
    }
}
