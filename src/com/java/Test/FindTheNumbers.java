package com.java.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by BHUVKUMA on 04-May-15.
 */
public class FindTheNumbers {
    ArrayList<Integer> arrayList = new ArrayList<Integer>();
    public static void main(String[] args){
        FindTheNumbers findTheNumbers = new FindTheNumbers();
        for (int i = 15; i > 0 ; i--) {
            findTheNumbers.arrayList.add(i*i);
        }
        Collections.sort(findTheNumbers.arrayList, new Comparator<Integer>() {
            @Override
            public int compare(Integer  no1, Integer  no2)
            {

                return  no1.compareTo(no2);
            }
        });

        System.out.println(findTheNumbers.arrayList);

        findTheNumbers.theNumbers(11);
        findTheNumbers.theNumbers(23);
        findTheNumbers.theNumbers(10);
        findTheNumbers.theNumbers(52);
    }

    void theNumbers(int K){
        int flag =0;
        int j,i = 0;
        for (j = i; j < arrayList.size() && flag == 0; ) {
//            System.out.printf(" ");
                if(arrayList.get(j) - arrayList.get(i) == K){
                    System.out.println("Nos are : " + arrayList.get(i) + " and " + arrayList.get(j));
                    flag = 1;
                }
                else if(arrayList.get(j) - arrayList.get(i) < K){
                    j++;
                    continue;
                }
                else{
                    i = i+1;
                    continue;
                }

        }
        if(flag == 0) System.out.println("No such pair found");
    }
}
