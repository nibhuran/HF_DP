package com.java.Test;

import java.util.Scanner;
import java.util.Stack;

public class IsBSTPossible {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer noOfTestCases = scanner.nextInt();
        System.out.println(noOfTestCases);
        while (noOfTestCases-- > 0){
            Integer noOfElements = scanner.nextInt();
            Integer[] nos = new Integer[noOfElements];
            for (int i = 0; i < noOfElements; i++) {
                nos[i] = scanner.nextInt();
            }
            System.out.println(isBSTPossible(nos, noOfElements));
        }
    }

    public static boolean isBSTPossible(Integer[] nos,Integer numberOfElements){
        Stack<Integer> stack = new Stack<>();
        Integer currentRoot = Integer.MIN_VALUE;
        for (int i = 0; i < numberOfElements; i++) {
            if(nos[i] < currentRoot){
                return false;
            }
            if(!stack.isEmpty()){
                if(nos[i] > stack.peek()){
                    currentRoot = popElementUntillSmaller(stack,nos[i]);
                }
            }
            stack.push(nos[i]);
        }
        return true;
    }

    public static Integer popElementUntillSmaller(Stack<Integer> stack, Integer number){
        Integer ans = stack.peek();
        while(!stack.isEmpty() && stack.peek() < number){
            ans = stack.pop();
        }
        return ans;
    }
}
