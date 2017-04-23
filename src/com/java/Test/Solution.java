package com.java.Test;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Integer[] array = {6,3,5,4,2,7};
        List<Integer> list = Arrays.asList(array);
        solution.maximumGap(list);
    }

    // DO NOT MODIFY THE LIST
    public int maximumGap(final List<Integer> A) {
        int n = A.size();
        int minLeft[] = new int[n];
        int maxRight[] = new int[n];

        minLeft[0] = A.get(0);
        System.out.print(minLeft[0] + " ");
        for (int i = 1; i < n; i++) {
            minLeft[i] = Math.min(minLeft[i - 1], A.get(i));
            System.out.print(minLeft[i] + " ");
        }
        System.out.println();


        maxRight[n - 1] = A.get(n - 1);
        System.out.print(maxRight[n-1] + " ");
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], A.get(i));
            System.out.print(maxRight[i] + " ");
        }
        System.out.println();

        int i = 0, j = n - 1;
        int max = -1;

        for (j = n - 1; j >= 0; j--) {
            int num = maxRight[j];
            i = minIndex(minLeft, num);
            max = Math.max(j - i, max);
            System.out.println("maxRight[j] : " + maxRight[j] +  "    i : " + i +"   max : " + max);
        }


        return max;
    }


    public int minIndex(int [] minLeft, int num) {

        int lo, hi, mid;
        int index = -1;

        lo = 0;
        hi = minLeft.length;

        while (lo <= hi) {
            mid = lo + ((hi - lo) >> 1);

            int minNum = minLeft[mid];

            if (num < minNum) {
                lo = mid + 1;
            } else {
                index = mid;
                hi = mid - 1;
            }
        }

        return index;

    }


}
