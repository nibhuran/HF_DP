package com.java.Test;

enum Move
{
    LEFT(true, true),
    RIGHT(false, true),
    UP(true, false),
    DOWN(false, false);

    private final boolean isIncremental;
    private final boolean isHorizontal;

    Move(boolean isIncremental, boolean isHorizontal)
    {
        this.isIncremental = isIncremental;
        this.isHorizontal = isHorizontal;
    }

    public boolean isIncremental()
    {
        return isIncremental;
    }

    public boolean isHorizontal()
    {
        return isHorizontal;
    }


}

class Board
{
    public static final int LAST = 6;
    int board[][];

    Board(int[][] board)
    {
        this.board = board;
        print();
    }

    public void print()
    {
        for (int i = 0; i <= LAST - 1; i++)
        {
            for (int j = 0; j <= LAST - 1; j++)
            {
                System.out.printf("%3s", board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-------------------------");
    }


    public void move(Move move)
    {
        for (int k = 0; k < LAST; k++)
        {
            for (int i = decideStartingIndex(move), j = increment(i, move); isInLimit(i, move) && isInLimit(j, move); )
            {
                if (getBoardValue(i, k, move) == 0)
                {
                    setBoardValue(i, k, move, getBoardValue(j, k, move));
                    setBoardValue(j, k, move, 0);
                    j = increment(j, move);
                }
                else if (getBoardValue(j, k, move) == 0)
                {
                    j = increment(j, move);
                }
                else if (getBoardValue(i, k, move) == getBoardValue(j, k, move))
                {
                    setBoardValue(i, k, move, 2*getBoardValue(j, k, move));
                    setBoardValue(j, k, move, 0);
                    j = increment(j, move);
                    i = increment(i, move);
                }
                else
                {
                    i = increment(i, move);
                    if (i == j)
                    {
                        j = increment(j, move);
                    }
                }
            }
        }
        System.out.println(move);
        print();
    }

    private int getBoardValue(int variableIndex, int constIndex, Move move)
    {
        if(move.isHorizontal())
        {
            return board[constIndex][variableIndex];
        }
        else
        {
            return board[variableIndex][constIndex];
        }
    }

    private void setBoardValue(int variableIndex, int constIndex, Move move, int valueToSet)
    {
        if(move.isHorizontal())
        {
            board[constIndex][variableIndex] = valueToSet;
        }
        else
        {
            board[variableIndex][constIndex] = valueToSet;
        }
    }

    private boolean isInLimit(int value, Move move)
    {
        return move.isIncremental() ? value < LAST : value > -1;
    }

    private int increment(int i, Move move)
    {
        return move.isIncremental() ? i+1 : i-1;
    }

    private int decideStartingIndex(Move move)
    {
        return move.isIncremental() ? 0 : LAST - 1;
    }
}

public class Game_Two_Zero_Four_Eight
{
    public static void main(String[] args)
    {
        int[][] arr = new int[][]
                {
                        { 2,  0,  2,  4,  4,  4},
                        { 0,  0,  2,  0,  2,  8},
                        { 0,  2,  4,  4,  4,  2},
                        { 4,  0,  0,  8,  2,  2},
                        { 4,  0,  0,  8,  2,  2},
                        { 4,  0,  0,  8,  2,  2}
                };
//        { 4,  4,  0,  0},
//        { 2,  0,  0,  0},
//        { 2,  8,  0,  0},
//        { 4,  8,  0,  0}

        Board board = new Board(arr);
        board.move(Move.LEFT);
        board.move(Move.UP);
        board.move(Move.DOWN);
        board.move(Move.LEFT);
        board.move(Move.RIGHT);
        board.move(Move.RIGHT);

    }
}
