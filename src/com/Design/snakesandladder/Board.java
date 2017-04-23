package com.Design.snakesandladder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by BHUVKUMA on 14-Apr-15.
 */
public class Board {
    //com.Design.snakesandladder.Snake[] snakeList = new com.Design.snakesandladder.Snake[];
    List<Snake> snakeList = new ArrayList<Snake>();
    int currentSnakeTail = 0;
    final int BOARD_SIZE = 100;

    public int getCurrentSnakeTail() {
        return currentSnakeTail;
    }

    public void setCurrentSnakeTail(int currentSnakeTail) {
        this.currentSnakeTail = currentSnakeTail;
    }



    public void addSnake(Snake snake){
        snakeList.add(snake);
        System.out.println(snake.toString());
    }

    public boolean isSnakeHeadThere(int position){

        for(Iterator<Snake> snakeIterator = snakeList.iterator();snakeIterator.hasNext();){
            Snake s = snakeIterator.next();
            if(s.getHead() == position){
                setCurrentSnakeTail(s.getTail());
                return true;
            }
        }
        return false;
    }

}
