package com.java.Test;

/**
 * Created by BHUVKUMA on 30-Apr-15.
 */


public class CouponCode {
    public static void main(String[] args){
        CouponCode c = new CouponCode();
        System.out.println("Result for 1 is : "+ c.maxCouponCode(1));
        System.out.println("Result for 12 is : "+ c.maxCouponCode(12));
        System.out.println("Result for 2 is : "+ c.maxCouponCode(2));
        System.out.println("Result for 1000 is : "+ c.maxCouponCode(1000));

    }

    int max(int a, int b){
        if (a > b)
            return a;
        return b;
    }

    int maxCouponCode(int couponCode){
        if(couponCode < 1)
            return 0;

        return max(couponCode, maxCouponCode(couponCode/2)+maxCouponCode(couponCode/3)+maxCouponCode(couponCode/4));
    }
}
