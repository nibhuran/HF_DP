package com.java.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by BHUVKUMA on 21-May-15.
 */
public class JsonEncoder {
    static JsonKey root;
    static JsonKey currentNode;
    static Map<String, JsonKey> jsonKeyMap = new HashMap<String, JsonKey>();

    public static void main(String[] args) {
        try {
            //Read the input lines
            readInput();

            //Print the formatted output
            print();
        } catch (Exception e){
            System.out.println("Invalid Input : " + e.getClass());
        }

        /*Sample Input
        10
        a.b=1
        a.c=2
        a.d.e.f=3
        a.d.e.g=4
        a.d.h.i=5
        a.d.h.j=6
        a.k=7
        a.k=8
        a.l=9
        a.m
        */

    }

    public static void print() {
        System.out.println("{");
        if(root != null) {
            root.print();
        }
        System.out.println("}");
    }

    public static void readInput() {
        int no_of_lines;
        Scanner scan = new Scanner(System.in);

        String no = scan.nextLine();
        no_of_lines = Integer.parseInt(no);

        while (no_of_lines-- > 0) {
            String line = scan.nextLine();
            String nameValue[] = line.split("=");
            nameValue[0] = nameValue[0].trim();
            if (nameValue.length > 1)
                nameValue[1] = nameValue[1].trim();

            String attribute[] = nameValue[0].split("\\.");

            if (nameValue.length > 1)
                insert(attribute, nameValue[1]);
            else
                insert(attribute, null);
        }
    }

    public static void insert(String[] attributes, String value) {
        int j = 0;
        currentNode = root;
        String tab = "\t";

        //If this is first entry, then root must be created
        if (root == null) {
            currentNode = new JsonKey();
            currentNode.setName(attributes[0]);
            root = currentNode;
            currentNode.position = "\t";
            jsonKeyMap.put(attributes[0], root);
            j = 1;
        }
        //if the first attribute is not the root, but some intermediate node
        if (!root.getName().equals(attributes[0])) {
            currentNode = jsonKeyMap.get(attributes[0]);
        }

        for (j = 1; j < attributes.length; j++) {
            //If the attribute is already there
            if (currentNode.has(attributes[j])) {
                currentNode = currentNode.get(attributes[j]);
                continue;
            }
            //Attribute is not there, must be created
            String parentPosition = currentNode.position;
            currentNode = currentNode.add(attributes[j]);
            currentNode.position = parentPosition + tab;
            jsonKeyMap.put(attributes[j], currentNode);
        }
        //set the value of the attribute
        currentNode.setValue(value);
    }

}
