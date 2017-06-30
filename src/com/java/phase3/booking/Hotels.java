package com.java.phase3.booking;

import java.util.*;

/**
 * Created by xps on 29-06-2017.
 */
public class Hotels {
    public static void main(String args[] ) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split("\\s");
        WordDictionary dictionary = new WordDictionary();
        for(int i = 0; i < words.length; i++) {
            dictionary.add(words[i].toLowerCase());
        }

        int noOfHotels = scanner.nextInt();

        Map<Integer, Integer> match = new HashMap<>();

        for (int i = 0; i < noOfHotels; i++) {

            int hotelId = scanner.nextInt();
            match.putIfAbsent(hotelId, 0);

            String review = scanner.nextLine();
            scanner.nextLine();
            int count = count(review, dictionary);

            match.put(hotelId, match.get(hotelId) + count);
        }

        match.keySet().stream()
                .sorted(Comparator.comparingInt(match::get))
                .sorted(Comparator.reverseOrder())
                .forEach(id -> System.out.printf("%d ", id));
    }

    private static int count(String review, WordDictionary wordDictionary) {
        int count = 0;
        String[] wordsInReview = review.split("[\\s.,!]+");
        for (String eachInReview : wordsInReview) {
            if(wordDictionary.contains(eachInReview.toLowerCase()))
                count++;
        }
        return count;
    }

    static class WordDictionary {

        static class Node {
            Node[] nexts = new Node[26];
            boolean end;
        }

        private Node root = new Node();

        public boolean contains(String word){
            char[] chars = word.toCharArray();
            Node current = root;
            for(char each : chars) {
                int index = each - 'a';
                if(current.nexts[index] == null) {
                    return false;
                }
                current = current.nexts[index];
            }
            return current.end;
        }

        public void add(String word){
            char[] chars = word.toCharArray();
            Node current = root;

            for(char each : chars) {
                int index = each - 'a';

                if(current.nexts[index] == null) {
                    current.nexts[index] = new Node();
                }
                current = current.nexts[index];
            }
            current.end = true;
        }
    }
}
