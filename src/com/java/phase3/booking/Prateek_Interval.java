package com.java.phase3.booking;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Created by xps on 28-06-2017.
 */
public class Prateek_Interval {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int currentExec = scanner.nextInt();

        int intervals = scanner.nextInt();
        List<Long> all = new ArrayList<>(intervals * 2);
        Map<Long, Integer> openings = new HashMap<>(intervals);
        Map<Long, Integer> closings = new HashMap<>(intervals);
        for (int i = 0; i < intervals; i++) {
            long start = scanner.nextLong();
            long end = scanner.nextLong();
            all.add(start);
            all.add(end);

            openings.put(start, openings.get(start) == null ? 1 :  openings.get(start) + 1);
            closings.put(end, closings.get(end) == null ? 1 :  closings.get(end) + 1);
        }

        int current = 0;
        int maxTillNow = 0;
        all.sort(Long::compare);

        for (long each : all) {
            if (openings.get(each) != null && openings.get(each) > 0) {
                current++;
                openings.put(each, openings.get(each) - 1);
            }
            if (closings.get(each) != null && closings.get(each) > 0) {
                current--;
                closings.put(each, closings.get(each) - 1);
            }
            if (maxTillNow < current) {
                maxTillNow = current;
            }
        }

        System.out.println(maxTillNow - currentExec);
    }
}
