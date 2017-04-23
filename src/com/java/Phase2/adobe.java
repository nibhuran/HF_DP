package com.java.Phase2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class adobe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
        char[] cons = { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x',
                'y', 'z' };

        int firstVowel = -1,lastConsonant = -1;
        int consVowel = -1;
        ArrayList<Character> vowel, con;
        List<String> strings = new ArrayList<>();
        //strings.stream().reduce()

        //I use lists for the .contains() method.

        con = new ArrayList<Character>();
        vowel = new ArrayList<Character>();

        for (Character c : vowels)
            vowel.add(c);
        for (Character c : cons)
            con.add(c);

        //Algorithm starts here
        for(int i = 0; i < s.length() - 1; i++)
        {
            //position i is a vowel
            if (vowel.contains(s.charAt(i)))
            {
                //if first vowel isn't set, set it
                if (firstVowel == -1)
                    firstVowel = i;
                if (!vowel.contains(s.charAt(i+1)))
                {
                    consVowel = i;
                    lastConsonant = i+1;
                }
            } else { //Otherwise it's a consonant.
                lastConsonant = i;  //set last consonant
            }
        }

        System.out.println(s.substring(consVowel, consVowel+2));
        System.out.println(s.substring(firstVowel,lastConsonant));

    }

    static void SmallestAndLargestSubstring(String s) {

        char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
        char[] cons = {
                'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x',
                'y', 'z' };
        char[] charArray = s.toLowerCase().toCharArray();
        int longStartIndex = 0;
        int shortStartIndex = 0;
        int shortEndIndex = 0;
        int longEndIndex = 0;
        boolean findVowel = false;
        int bestStart = 0;
        int bestEnd = 0;
        int shortest = Integer.MAX_VALUE;

        for (int i = 0; i < charArray.length; i++) {
            for (int z = 0; z < vowels.length; z++) {
                if (charArray[i] == vowels[z]) {
                    if (!findVowel) {
                        // if this is the first vowel we see
                        longStartIndex = i;
                        shortStartIndex = i;
                        findVowel = true;
                    } else {
                        shortStartIndex = i;
                    }
                }
            }
            for (int j = 0; j < cons.length; j++) {
                if (charArray[i] == cons[j]) {
                    if (findVowel) {
                        // if we have seen any vowel, this consonant is useless
                        longEndIndex = i; // this one is always than the previous for the largest
                        shortEndIndex = i; // we have to check if this one is better or not
                        if (shortEndIndex - shortStartIndex < shortest) {
                            bestStart = shortStartIndex;
                            bestEnd = shortEndIndex;
                            shortest = shortEndIndex - shortStartIndex;
                        }
                    }
                }
            }
        }
        System.out.println(s.substring(bestStart, bestEnd+1));
        System.out.println(s.substring(longStartIndex, longEndIndex+1));
    }
}
