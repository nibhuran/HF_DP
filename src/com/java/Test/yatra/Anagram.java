package com.java.Test.yatra;

import java.util.HashMap;
import java.util.Map;

public class Anagram {

    public static void main(String[] args) {
        String[] a = { "cdok", "hhpddlnnsjfoyxpci", "a", "jk", "abb", "mn", "abc"};
        String[] b = { "bckk", "ioigvjqzfbpllssuj", "bb", "kj", "bbc", "op", "def"};
        int[] result = getMinimumDifference(a, b);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }


    static int[] getMinimumDifference(String[] a, String[] b) {
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            String first = a[i];
            String second = b[i];
            if(first.length() != second.length()){
                result[i] = -1;
                continue;
            }
            Map<Character, Integer> firstMap = new HashMap<>(a[i].length());
            Map<Character, Integer> secondMap = new HashMap<>(b[i].length());
            for (int j = 0; j < a[i].length(); j++) {
                firstMap.putIfAbsent(first.charAt(j), 0);
                firstMap.put(first.charAt(j), firstMap.get(first.charAt(j)) + 1);

                secondMap.putIfAbsent(second.charAt(j), 0);
                secondMap.put(second.charAt(j), secondMap.get(second.charAt(j)) + 1);
            }
            for(Map.Entry<Character, Integer> entry : firstMap.entrySet()){
                if(secondMap.get(entry.getKey()) != null){
                    int diff = entry.getValue() - secondMap.get(entry.getKey());
                    if(diff > 0){
                        entry.setValue(diff);
                    } else {
                        entry.setValue(0);
                    }
                }
            }
            int count = 0;
            for(Map.Entry<Character, Integer> entry : firstMap.entrySet()){
                count = count + entry.getValue();
            }
            result[i] = count;
        }
        return result;
    }
}
