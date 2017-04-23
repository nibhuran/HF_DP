package com.java.Phase2.InterviewBit.day2;

import java.util.ArrayList;

public class MergeInterval {

    public static void main(String[] args) {

        ArrayList<Interval> intervals = new ArrayList<>();
        Interval a = new Interval(1, 3);
        Interval b = new Interval(6, 9);
        intervals.add(a);
        intervals.add(b);

        Interval interval = new Interval(2, 5);

        insert(intervals, interval);
        intervals.forEach(interval1 -> System.out.println(interval1));
    }




    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        if(newInterval.start < intervals.get(0).start){

        }
        for (Interval interval : intervals){
        }
        return intervals;
    }


    /**
     * Definition for an interval. */
      public static class Interval {
          int start;
          int end;
          Interval() { start = 0; end = 0; }
          Interval(int s, int e) { start = s; end = e; }

        @Override public String toString() {
            return "(" + this.start +", " + this.end + ")";
        }
    }
}
