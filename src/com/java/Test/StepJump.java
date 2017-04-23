package com.java.Test;

import java.util.ArrayList;

/**
 * Created by BHUVKUMA on 30-Apr-15.
 */
public class StepJump {
    public static void main(String[] args){
        int flag = 0;
        StepJump s = new StepJump();
        System.out.println("Result for 2, 2 : "+ s.calculateMaxStep(2,2));
        System.out.println("Result for 2, 1 : "+ s.calculateMaxStep(2,1));
        System.out.println("Result for 6, 3 : "+ s.calculateMaxStep(6,3));
        System.out.println("Result for 6, 10 : "+ s.calculateMaxStep(6,10));
        System.out.println("Result for 6, 11 : "+ s.calculateMaxStep(6,11));
    }

    int calculateMaxStep(int N, int K){
        int sum = (N*(N+1))/2;
        int temp;
        ArrayList<Integer> nthSum = new ArrayList<Integer>();
        nthSum.add(0);
        if(K > sum){
            return sum;
        }
        for (int i = 1; i < 2001; i++) {
            temp = (i*(i+1))/2;
            nthSum.add(temp);
        }

        for (int i = 1; i < 2001; i++) {
            if(nthSum.get(i) == K)
                return sum-1;
        }
        return sum;
    }
}
