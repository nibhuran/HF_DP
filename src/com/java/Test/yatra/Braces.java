package com.java.Test.yatra;

import java.util.Scanner;
import java.util.Stack;

public class Braces {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < testCases; i++) {
            String string = scanner.nextLine();
            if(isValid(string)){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean isValid(String string){
        boolean result = false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < string.length(); i++) {
            Character character = string.charAt(i);
            if(character == '(' || character == '{' || character == '['){
                stack.push(character);
            } else if(stack.isEmpty() && (character == ')' || character == '}' || character == ']')){
                return result;
            } else {
                if((character == ')' && stack.peek() == '(') || (character == '}' && stack.peek() == '{') || (character == ']' && stack.peek() == '[')){
                    stack.pop();
                } else {
                    return result;
                }
            }
        }
        if(stack.isEmpty()){
            result = true;
        }
        return result;
    }


    static String[] braces(String[] values) {
        String [] output = new String[values.length];
        for (int  i = 0; i < values.length; i++) {
            String string = values[i];
            if(isValid(string)){
                output[i] = "YES";
            } else {
                output[i] = "NO";
            }
        }
        return output;
    }
}
