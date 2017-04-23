package com.java.Test;

import java.util.HashMap;
import java.util.Map;

public class MaxLengthSubstringWithoutDuplicate {

    public static void main(String[] args) {
        String input = "bhuvneshwar";
        Map<Character, Integer> occurance = new HashMap<>(26);
        int first = 0;
        int BEST_RESULT = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(occurance.get(c) != null){
                first = occurance.get(c) + 1;
                occurance.put(c, i);
            } else {
                occurance.put(c, i);
                if(BEST_RESULT < (i + 1 - first)){
                    BEST_RESULT = i + 1 - first;
                }
            }
        }
        System.out.println("best result is : " + BEST_RESULT);
    }
}
