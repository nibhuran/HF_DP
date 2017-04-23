package com.Design.snakesandladder;

/**
 * Created by BHUVKUMA on 14-Apr-15.
 */
public class Player {
    public String name;
    public int startPosition;
    public int currentPosition;


    public Player(String name) {
        this.name = name;
        this.startPosition = 0;
        this.toString();
    }


    public Player(String name, int startPosition) {
        this.name = name;
        this.startPosition = startPosition;
        setCurrentPosition(startPosition);
        this.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(int startPosition) {
        this.startPosition = startPosition;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", startPosition=" + startPosition +
                ", currentPosition=" + currentPosition +
                '}';
    }


    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }




}
