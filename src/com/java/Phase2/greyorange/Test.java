package com.java.Phase2.greyorange;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    static int playlist(String[] songs, int k, String q) {
        Map<String, List<Integer>> map =new HashMap<>();
        int index = 0;
        for (String song : songs) {
            map.computeIfAbsent(song, p -> new ArrayList<>()).add(index);
            index++;
        }
        List<Integer> indexOfQ = map.get(q);
        Integer min = Integer.MAX_VALUE;
        Integer left, right;
        if(k < indexOfQ.get(0) || k > indexOfQ.get(indexOfQ.size() - 1)) {
            left = indexOfQ.get(indexOfQ.size() -1);
            right = indexOfQ.get(0);
        } else{
            int i =0;
            for (; i < indexOfQ.size() && k<indexOfQ.get(i); i++) {
            }
            left = indexOfQ.get(i-1);
            right = indexOfQ.get(i);
        }
        Integer ldis = k >left ? k- left : k + songs.length - right;
        Integer rdis = k < right ? right - k : songs.length - k + right;

        return Math.min(ldis, rdis) + 1;
    }

}
/*

    */
/*
     * Complete the function below.
     *//*

    //1,6,10
    static long countSum(int[] numbers) {
        int result  = 0;
        for(int i = 0 ; i < numbers.length ; i++){
            for(int j = 1 ; j*j <= numbers[i] ; j++){
                if(numbers[i] % j == 0 ){
                    if(j%2 != 0)
                        result += j;
                    //System.out.println("j " + j);
                    if((numbers[i]/j) % 2 !=  0 && numbers[i] != j*j){
                        result+=numbers[i]/j;
                        //System.out.println("j-" + numbers[i]/j);
                    }
                }
            }
        }
        return result;
    }

*/