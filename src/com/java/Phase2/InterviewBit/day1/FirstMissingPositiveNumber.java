package com.java.Phase2.InterviewBit.day1;

import java.util.ArrayList;
import java.util.Arrays;

public class FirstMissingPositiveNumber {
    public static void main(String[] args) {
        //Integer[] array = {1,4,3,7,5,-1,2,-1,8};

        //Integer[] array = {229, 888, 742, 191, 843, 721, 268, 439, 238, 585, 120, 514, 201, 829, 334, 467, 636, 735, 743, 405, 541, 710, 798, 632, 397, 625, 440, 508, 794, 696, 319, 810, 297, 369, 425, 617, 520, 216, 43, 759, 258, 914, 863, 929, 638, 656, 699, 648, 275, 786, 315, 370, 462, 969, 828, 727, 756, 200, 243, 842, 46, 110, 158, 361, 224, 560, 539, 874, 505, 621, 661, 8, 808, 635, 609, 213, 844, 67, 922, 74, 481, 237, 174, 449, 40, 154, 905, 571, 558, 952, 24, 658, 662, 179, 686, -4, 784, 300, 755, 873, 618, 981, 928, 286, 188, 150, 73, 1000, 598, 225, 814, 595, 532, 673, 793, 290, 774, 909, 876, 855, 375, 235, 524, 365, 613, 333, 7, 336, 848, 959, 797, 328, 90, 629, 140, 59, 69, 339, 640, 199, 732, 317, 395, 940, 263, 799, 172, 570, 56, 730, 468, 461, 801, 282, 502, 389, 295, 871, 740, 921, 35, 933, 690, 717, 778, 48, 547, 257, 823, 272, 985, 681, 528, 204, 536, 889, 486, 305, 586, 956, 861 };
        //Integer[] array = {1};
        Integer[] array = {1, 2, 3, 4, 5, 6};


        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(array));
        System.out.println(a.size());
        System.out.println(firstMissingPositive(a));
    }

    private static int firstMissingPositive(ArrayList<Integer> a) {
        int result = 1;
        int size = a.size();
        for (int i = 0; i < size; i++) {
            int startIndex = a.get(i) - 1;
            while (startIndex >= 0 && startIndex < size/* &&  a.get(startIndex) > 0 && a.get(startIndex) <= size + 1*/){
                int desIndex = a.get(startIndex) - 1;
                a.set(startIndex, Integer.MIN_VALUE);
                startIndex = desIndex;
            }
        }
        boolean flag = false;
        for (int i = 0; i < size; i++) {
            if(a.get(i) != Integer.MIN_VALUE){
                result = i + 1;
                flag = true;
                break;
            }
        }
        if(!flag){
            result = size + 1;
        }
        return result;
    }

}
