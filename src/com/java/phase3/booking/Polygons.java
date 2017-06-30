package com.java.phase3.booking;

import java.util.Scanner;

/**
 * Created by xps on 29-06-2017.
 */
public class Polygons {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int squares = 0;
        int rect = 0;
        int quad = 0;
        while (scanner.hasNext()){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int d = scanner.nextInt();
            if(a > 0 && a==b && b==c && c==a){
                squares++;
            } else if(a > 0 && b > 0 && a==c && b==d){
                rect++;
            } else {
                quad++;
            }
        }
        System.out.println(squares + " " + rect + " " + quad);
    }
}
