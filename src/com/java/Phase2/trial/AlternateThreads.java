package com.java.Phase2.trial;

public class AlternateThreads {
    private volatile int number = 0;

    public static void main(String[] args) {
        MyThread firstThread = new MyThread(0, 3, 3);
        MyThread secondThread = new MyThread(1, 3, 3);
        MyThread thirdThread = new MyThread(2, 3, 3);
        firstThread.setToNotify(secondThread);
        secondThread.setToNotify(thirdThread);
        thirdThread.setToNotify(firstThread);

        firstThread.run();
        secondThread.run();
        thirdThread.run();

        firstThread.notify();

    }

    public static class MyThread implements Runnable {
        Integer  start;
        Integer  diff;
        Integer  count;
        MyThread toNotify;
        boolean  running;

        public MyThread(Integer start, Integer diff, Integer count) {
            this.start = start;
            this.diff = diff;
            this.count = count;
        }

        public void setToNotify(MyThread toNotify) {
            this.toNotify = toNotify;
        }

        @Override
        public void run() {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.running = true;
            for (int i = 0; i < count; i++) {
                System.out.println(start + i * diff);
                if (toNotify.running) {
                    toNotify.notify();
                } else {
                    toNotify.run();
                }
            }
        }
    }
}
