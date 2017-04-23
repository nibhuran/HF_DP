package com.java.Phase2.InterviewBit.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestNumber {
    public static void main(String[] args) {
        //Integer[] array = {1, 2, 3, 4, 5, 6};
        //Integer[] array = {0, 0, 0, 0, 0};
        Integer[] array = {0, 0, 0, 0, 0, 1};
        List<Integer> list = new ArrayList<>(Arrays.asList(array));
        System.out.println(largestNumber(list));
    }

    private static String largestNumber(final List<Integer> a) {
        String result = "";
        List<MyIntegerClass> myIntegerClassList = new ArrayList<>(a.size());
        for (Integer anA : a) {
            MyIntegerClass myIntegerClass = new MyIntegerClass(anA);
            myIntegerClassList.add(myIntegerClass);
        }
        Collections.sort(myIntegerClassList);
        for (MyIntegerClass myIntegerClass : myIntegerClassList) {
            result = result + myIntegerClass.number.toString();
        }

        int i = 0;
        while (i < result.length() && result.charAt(i) == '0'){
            i++;
        }
        if(i == result.length()){
            return "0";
        }
        return result.substring(i);
    }

    public static class MyIntegerClass implements Comparable {
        private Integer number;

        MyIntegerClass(Integer number) {
            this.number = number;
        }
        @Override public int compareTo(Object o) {
            MyIntegerClass second = (MyIntegerClass) o;
            String firstSecond = this.number.toString().concat(second.number.toString());
            String secondFirst = second.number.toString().concat(this.number.toString());
            return secondFirst.compareTo(firstSecond);
        }
    }
}
