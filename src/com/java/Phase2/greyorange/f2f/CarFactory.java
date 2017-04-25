package com.java.Phase2.greyorange.f2f;

public class CarFactory {
    public static void main(String[] args) {
        Integer[] t1 = {10,20,30,9};
        Integer[] t2 = {5 , 6,40,2};

        Integer[][] costInBetween = {{5,10},{5,10}, {5,10}};

        Integer s1=5, s2 =10, e1=10, e2=5;

        System.out.println(findMinimumTime(t1, t2, costInBetween, s1, s2, e1, e2));
    }

    public static int findMinimumTime(Integer[] t1, Integer[] t2, Integer[][] costInBetween, Integer s1, Integer s2, Integer e1, Integer e2){
        if(t1.length != t2.length || costInBetween.length != t1.length-1){
            throw new RuntimeException("Invalid Input");
        }
        Integer[] v1 = new Integer[t1.length];
        Integer[] v2 = new Integer[t2.length];
        v1[0] = s1;
        v2[0] = s2;

        int i = 1;
        for (; i < t1.length;i++){
            v1[i] = Math.min( (v1[i-1] + t1[i-1]), (v2[i-1] + t2[i-1] + costInBetween[i-1][0]));
            v2[i] = Math.min( (v2[i-1] + t2[i-1]), (v1[i-1] + t1[i-1] + costInBetween[i-1][1]));
        }

        return Math.min(v1[i-1] + e1, v2[i-1] + e2);
    }
}
