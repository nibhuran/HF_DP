package com.Design.snakesandladder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by BHUVKUMA on 14-Apr-15.
 */
public class Game {
    public Board gameBoard = new Board();
    List<Player> playerList = new ArrayList<Player>();
    Dice dice = new Dice();
    int snakeBiteCount = 0;

    public static void main(String[] args){

        Game game = new Game();
        System.out.println("Game Started");

        game.addPlayer("Ross");
        game.addPlayer("Joey");
        //game.addPlayer("Monica");

        game.gameBoard.addSnake(new Snake(50, 5));
        game.gameBoard.addSnake(new Snake(10, 5));
        game.gameBoard.addSnake(new Snake(13, 5));
        game.gameBoard.addSnake(new Snake(19, 5));


        game.playGame();

        System.out.println("Game end!!");

    }

    public void playGame() {
        //System.out.println(" is playing.."+playerList.size());
        while (playerList.isEmpty() == false) {
            for (Iterator<Player> playerIterator = playerList.iterator(); playerIterator.hasNext(); ) {
                Player currentPlayer = playerIterator.next();
                System.out.println("***********" + currentPlayer.getName() + " is playing..");
                int chance = dice.rollDice();
                System.out.println("Dice rolled, generated chance is: " + chance);
                int currentPlayerPosition = currentPlayer.getCurrentPosition() + chance;

                if (gameBoard.isSnakeHeadThere(currentPlayerPosition)) {
                    currentPlayer.setCurrentPosition(gameBoard.currentSnakeTail);
                    System.out.println("!!!!!!! Snake bite, new position now is: " + currentPlayer.getCurrentPosition());

                    continue;
                }
                if(currentPlayerPosition == gameBoard.BOARD_SIZE){
                    System.out.println(currentPlayer.getName() + " has reached 100****************");
                    playerIterator.remove();



                    continue;
                }
                else if(currentPlayerPosition > gameBoard.BOARD_SIZE){
                    System.out.println("Invalid Move + "+ currentPlayer.getCurrentPosition());
                    continue;
                }
                //If no snake there
                currentPlayer.setCurrentPosition(currentPlayerPosition);
                System.out.println(currentPlayer.getName() + "'s new position is " + currentPlayerPosition);
            }
        }
    }

    public void addPlayer(String name){
        Player p = new Player(name);
        playerList.add(p);
        System.out.println(p.toString());
    }

    /*
    public static int rollDice() {
        int min = 1;
        int max = 6;
        // NOTE: Usually this should be a field rather than a method
        // variable so that it is not re-seeded every call.
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
    */
}
