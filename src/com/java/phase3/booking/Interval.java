package com.java.phase3.booking;

import java.util.*;

/**
 * Created by xps on 28-06-2017.
 */
public class Interval {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int givenCount = scanner.nextInt();

        int intervals = scanner.nextInt();
        List<TimeS> timeS = new ArrayList<>(intervals*2);
        for (int i = 0; i < intervals; i++) {
            long start = scanner.nextLong();
            long end = scanner.nextLong();
            timeS.add(new TimeS(start, true));
            timeS.add(new TimeS(end, false));
        }

        int current = 0;
        int result = 0;
        timeS.sort((o1, o2) -> {
            Long diff = (o1.getTime() - o2.getTime());
            return diff.intValue();
        });

        System.out.println(timeS);

        for (TimeS timeS1 : timeS){
            if(timeS1.isOpening){
                current++;
            } else {
                current--;
            }
            if(result < current){
                result = current;
            }
        }
        System.out.println(result - givenCount > 0 ? result - givenCount : 0);
    }


    public static class TimeS{
        Long time;
        Boolean isOpening;

        public TimeS(Long time, Boolean isOpening) {
            this.time = time;
            this.isOpening = isOpening;
        }

        public Long getTime() {
            return time;
        }

        public void setTime(Long time) {
            this.time = time;
        }

        public Boolean getOpening() {
            return isOpening;
        }

        public void setOpening(Boolean opening) {
            isOpening = opening;
        }

        @Override
        public String toString() {
            return "TimeS{" +
                    "time=" + time +
                    ", isOpening=" + isOpening +
                    '}';
        }
    }
}
