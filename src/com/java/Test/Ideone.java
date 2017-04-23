package com.java.Test;

import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * Created by BHUVKUMA on 14-May-15.
 */

class Ideone
{
    public static void main (String[] args) throws java.lang.Exception
    {
        printBalExpression(3, 0, 0, "");
    }


    private static void 	printBalExpression(int N, int open, int closed, String tillNow)
    {
        if(closed < open)
        {
            printBalExpression (N, open, closed+1, tillNow + ")");	//1,1 ()
        }
        if(open < N )
        {
            printBalExpression (N, open +1, closed, tillNow + "(");	// 1,0, (
        }


        if(open == closed && open == N)
        {
            System.out.println(tillNow);
        }
    }

}