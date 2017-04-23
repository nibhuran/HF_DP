package com.java.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by BHUVKUMA on 01-May-15.
 */


public class LevelOrder {
    public static void main(String[] args){
        //LevelOrder levelOrder = new LevelOrder();


        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.right.left = new TreeNode(10);
        root.right.left.right = new TreeNode(13);

        Tree tree = new Tree(root);

        printLevelOrderTraversal(root);
        printUsingStack(root);
        printspiralView(root);

    }

    public static void printspiralView(TreeNode root) {
        System.out.println("\nSpiral View Traversal: ");

        if (root == null) {
            return;
        }

        boolean isEvenLevel = true;

       // List<TreeNode> list = new

        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();

        stack1.push(root);


        while ( (stack2.isEmpty() == false) || (stack1.isEmpty() == false)) {
            TreeNode current;
            if(isEvenLevel){
                current = stack1.pop();
            }
            else{
                current = stack2.pop();
            }


            System.out.printf(current.data + " ");

            if (isEvenLevel == true) {
                if (current.right != null) {
                    stack2.push(current.right);
                }
                if (current.left != null) {
                    stack2.push(current.left);
                }
            } else {
                if (current.left != null) {
                    stack1.push(current.left);
                if (current.right != null) {
                    stack1.push(current.right);
                }
                }
            }
            if(isEvenLevel){
                if(stack1.isEmpty() == true){
                    isEvenLevel = isEvenLevel ? false : true;
                }
            }
            else {
                if(stack2.isEmpty() == true){
                    isEvenLevel = isEvenLevel ? false : true;
                }
            }


        }

    }


    public static void printUsingStack( TreeNode root){
        System.out.println("\nUsing Stack :");

        if(root ==  null){
            return;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();

        stack.push(root);

        while(stack.isEmpty() == false){

            TreeNode current = stack.pop();

            System.out.printf(current.data+" ");

            if(current.left != null){
                stack.push(current.left);
            }
            if(current.right != null){
                stack.push(current.right);
            }
        }
    }

    public static void printLevelOrderTraversal(TreeNode root){
        System.out.println("\nLevel Order Traversal: ");

        if(root == null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.add(root);

        while(queue.isEmpty() == false){


            TreeNode current = queue.remove();
            System.out.printf(current.data + " ");

            if(current.left != null){
                queue.add(current.left);
            }
            if(current.right != null){
                queue.add(current.right);
            }
        }
    }

    /*
    class Tree{
        TreeNode root;

        public Tree(){}

        public Tree(TreeNode root){
            this.root = root;
        }
    }

    class TreeNode{
        int data;
        TreeNode leftChild, rightChild;


        public TreeNode(int data) {
            this.data = data;
        }
    }
    */

}
