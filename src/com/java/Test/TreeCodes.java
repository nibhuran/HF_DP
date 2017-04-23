package com.java.Test;

// Game_Two_Zero_Four_Eight driver class
public class TreeCodes
{
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(25);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        Tree tree = new Tree(root);

        System.out.println("Bottom view of the given binary tree:");
        tree.genericView(Mode.BOTTOM);

        System.out.println("\nTop view of the given binary tree:");
        tree.genericView(Mode.TOP);

        System.out.println("\nRight view of the given binary tree:");
        tree.genericView(Mode.RIGHT);

        System.out.println("\nLeft view of the given binary tree:");
        tree.genericView(Mode.LEFT);

        System.out.println("");
        System.out.println("Size of the tree : " + tree.size());

        System.out.printf("All root to leaf path in the tree: \n");
        tree.printPath(root);

        //System.out.printf("\n\nMirroring the tree \n");
        //tree.mirror(root);
        System.out.printf("All root to leaf path in the tree: \n");
        tree.printPath(root);


        System.out.println("\nBinary Tree to DLL");
        tree.binaryTreeToDLLWithInorderTraversal(root);
        /*System.out.println("\nBinary Tree to DLL");
        TreeNode dllHead = tree.binaryTreeToDLL(root);

        System.out.println("\n\nDLL to Binary Tree: ");
        root = tree.dLLToBinaryTree(dllHead);
        System.out.printf("All root to leaf path in the tree: \n");
        tree.printPath(root);*/
    }
}