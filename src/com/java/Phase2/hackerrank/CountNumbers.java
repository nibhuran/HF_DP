package com.java.Phase2.hackerrank;

public class CountNumbers {
    public static void main(String[] args) {
        int[][] array = { { 52, 80 }, { 57, 64 }, { 1, 20 }, { 1, 11 }, { 74, 78 }, { 1, 1000000 }, { 11, 21 }, { 12, 22 }, { 11, 23 } };
        int[][] arr = { { 11, 1111 }, { 10, 1111 }, { 11, 1110 }, { 10, 1111 } };
        countNumbers(arr);
    }

    static void countNumbers(int[][] arr) {
        Integer[] numbers = new Integer[54];
        Integer[] n = { 11, 22, 33, 44, 55, 66, 77, 88, 99 };
        for (int i = 0; i < 9; i++) {
            numbers[i] = n[i];
        }
        for (int i = 1; i < 6; i++) {
            for (int j = 0; j < 9; j++) {
                numbers[i * 9 + j] = numbers[(i - 1) * 9 + j] * 10 + j + 1;
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
        //System.out.println(numbers.toString());
        for (int i = 0; i < arr.length; i++) {
            int start = findIndex(numbers, arr[i][0]);
            //System.out.println(start + " " + numbers[start]);
            int end = findGreaterIndex(numbers, arr[i][1]);
            //System.out.println(end + " " + numbers[end]);
            System.out.println(arr[i][1] - arr[i][0] - (end - start));
        }
    }

    public static int findIndex(Integer[] numbers, int no) {
        int i = 0;
        while (i < numbers.length && no > numbers[i])
            i++;
        return i;
    }

    public static int findGreaterIndex(Integer[] numbers, int no) {
        int i = numbers.length - 1;
        while (i >= 0 && no < numbers[i])
            i--;
        return i;
    }

    //1226#24# abzx
    //1(2)23(3) aa b ccc
    //2110#(2) a b jj
    //23#(2)24#25#26#23#(3) ww x y z www
}
