package com.Design.snakesandladder;

/**
 * Created by BHUVKUMA on 14-Apr-15.
 */
public class Snake extends Entity{

    int head;


    public int getHead() {
        return head;
    }

    @Override
    public String toString() {
        return "Snake{" +
                "head=" + head +
                ", tail=" + end +
                '}';
    }

    public void setHead(int head) {
        this.head = head;
    }

    public int getTail() {
        return outcome.returnOutcome(end);
    }

    public void setTail(int tail) {
        this.end = tail;
    }


    public Snake(int head, int tail) {
        this.head = head;
        this.end = tail;
        this.outcome = new FixedOutcome();
    }
}
