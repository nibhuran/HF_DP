package com.java.Test;

public class SortListWithTwoIntegers {
    public static void main(String[] args) {
        Integer[] array = {0,0,0,0,0,0,0,1};
        System.out.println("found at : " + binarySearch(array, 0, array.length-1));
    }

    private static Integer binarySearch(Integer[] array, int start, int end){
        if(start > end) return null;
        int mid = (start + end) / 2;
        if(array[mid] == 1 && ((mid > 0) && array[mid-1] == 0)){
            return mid;
        } else if (array[mid] == 0 && ((mid < array.length-1) && array[mid + 1] == 0)) {
             return binarySearch(array, mid + 1, end);
        }
        else if(array[mid] == 1 && ((mid < array.length-1) && array[mid + 1] == 1)) {
            return binarySearch(array, start, mid);
        }
        return null;
    }
}
