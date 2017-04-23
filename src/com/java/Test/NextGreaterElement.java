package com.java.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer noOfTestCases = scanner.nextInt();
        //System.out.println(noOfTestCases);
        while (noOfTestCases-- > 0){
            Integer noOfElements = scanner.nextInt();
            List<Integer> nos = new ArrayList<Integer>(noOfElements);
            while (noOfElements-- > 0){
                nos.add(scanner.nextInt());
            }

            Stack<Integer> stack = new Stack<Integer>();
            List<Integer> output = new ArrayList<Integer>(Collections.nCopies(nos.size(), -1));
            stack.push(nos.get(nos.size()-1));
            for (int i = nos.size() - 2 ; i > -1 ; i--) {
                if(!stack.isEmpty() && nos.get(i) < stack.peek()){
                    output.set(i, stack.peek());
                    stack.push(nos.get(i));
                } else if(!stack.isEmpty() && nos.get(i) > stack.peek()){
                    do {
                        if(stack.peek() < nos.get(i)){
                            stack.pop();
                        } else {
                            output.set(i, stack.peek());
                            stack.push(nos.get(i));
                            break;
                        }
                    } while (!stack.isEmpty());
                    if(stack.isEmpty()){
                        stack.push(nos.get(i));
                    }
                }
            }
            for (Integer i : output){
                System.out.printf(i + " ");
            }
            System.out.println();
        }
    }
}
