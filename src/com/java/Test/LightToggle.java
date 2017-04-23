package com.java.Test;

/**
 * Created by BHUVKUMA on 30-Apr-15.
 */
public class LightToggle {
    public static void main(String[] args){
        LightToggle l = new LightToggle();
        System.out.println("Result for 10 is: "+l.noOfOnBulbs(10));
        System.out.println("Result for 100 is: "+l.noOfOnBulbs(100));

    }

    int noOfOnBulbs(int no){
        int res = 0;
        for (int i = 1; i*i <= no; i++) {
            res++;
        }
        return res;
    }
}
