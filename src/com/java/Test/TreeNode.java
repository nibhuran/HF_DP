package com.java.Test;// Java Program to print any View of Binary Tree

import java.util.*;
import java.util.LinkedList;
import java.util.Map.Entry;

enum Mode {
    TOP(false, false),
    BOTTOM(false, true),
    LEFT(true, true),
    RIGHT(true, false);

    private final boolean isHorizontal;
    private final boolean isIncremental;

    Mode(boolean isHorizontal, boolean isIncremental) {
        this.isHorizontal = isHorizontal;
        this.isIncremental = isIncremental;
    }

    public boolean isHorizontal() {
        return isHorizontal;
    }

    public boolean isIncremental() {
        return isIncremental;
    }

}

// Tree node class
public class TreeNode {
    int      data;        //data of the node
    int      hd;          //horizontal distance of the node
    TreeNode left, right; //left and right references

    // Constructor of tree node
    public TreeNode(int data) {
        this.data = data;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}

//Tree class
class Tree {
    TreeNode              root;                                          //root node of tree

    Map<Integer, Integer> mapValue     = new TreeMap<Integer, Integer>();
    Map<Integer, Integer> mapMinorAxis = new TreeMap<Integer, Integer>();
    Mode                  mode;

    static TreeNode              temp;                                          // To Calculate tree size
    TreeNode headOfDLL;

    // Default constructor
    public Tree() {
    }

    // Parameterized tree constructor
    public Tree(TreeNode node) {
        root = node;
        temp = root;
    }

    public void genericView(Mode Mode) {
        this.mode = Mode;
        mapValue.clear();
        mapMinorAxis.clear();

        if (root == null) {
            return;
        }
        TreeNode temp = root;
        inorderTraverse(temp, 0, 0);

        printView();

    }

    public void inorderTraverse(TreeNode current, int x, int y) {
        if (current == null) {
            return;
        }

        //Traverse Left
        if (current.left != null) {
            inorderTraverse(current.left, x - 1, y - 1);
        }

        //Traverse itself
        if (!mapValue.containsKey(majorAxisValue(x, y)) || isUpdateNeeded(minorAxisValue(x, y), mapMinorAxis.get(majorAxisValue(x, y)))) {
            mapMinorAxis.put(majorAxisValue(x, y), minorAxisValue(x, y));
            mapValue.put(majorAxisValue(x, y), current.data);
        }

        //Traverse right
        if (current.right != null) {
            inorderTraverse(current.right, x + 1, y - 1);
        }
    }

    int majorAxisValue(int x, int y) {
        return mode.isHorizontal() ? y : x;
    }

    int minorAxisValue(int x, int y) {
        return mode.isHorizontal() ? x : y;
    }

    boolean isUpdateNeeded(int currentMinorAxis, int storedMinorAxis) {
        return mode.isIncremental() ? (currentMinorAxis < storedMinorAxis) : (currentMinorAxis > storedMinorAxis);
    }

    public int size() {
        return size(root);
    }

    int size(TreeNode root) {
        TreeNode temp = root;

        if (temp == null)
            return 0;

        return (1 + size(root.left)) + size(root.right);

    }

    public void printPath(TreeNode root) {
        int[] pathArray = new int[500];
        printPath(root, pathArray, 0);
    }

    void printPath(TreeNode root, int[] path, int pathlength) {
        if (root == null) {
            return;
        }

        path[pathlength] = root.data;
        pathlength++;

        if (root.right == null && root.left == null) {
            print(path, pathlength);
        }

        else {
            printPath(root.left, path, pathlength);
            printPath(root.right, path, pathlength);
        }
    }

    public void print(int[] array, int pathlength) {
        System.out.printf("Path is : ");
        for (int i = 0; i < pathlength; i++) {
            System.out.printf(array[i] + " ");
        }
        System.out.printf("\n");
    }

    public void mirror(TreeNode root) {
        if (root == null) {
            return;
        }

        mirror(root.left);
        mirror(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return;
    }



	/*
	bst to dll
	static Node prev = null;
	static Node head = null;
	traverseTree(Node current){
		if(current == null){
			return;
		}
		traverseTree(root.left);

		{
			if(prev == null){
				head = current;
			} else{
				prev.right = current;
				current.left = prev;
			}
			prev = current;
		}

		traverseTree(root.right);
	}

	 */

    void binaryTreeToDLLWithInorderTraversal(TreeNode root){
        if(root == null){
            System.out.println("Empty Tree");
            return;
        }
        temp = null;
        traverseInorder(root);

        temp = headOfDLL;
        while (temp != null){
            System.out.printf(temp.data + "->");
            temp = temp.right;
        }
    }

    private void traverseInorder(TreeNode current) {
        if(current == null){
            return;
        }
        traverseInorder(current.left);

        {
            if(temp == null){
                headOfDLL = current;
            } else {
                temp.right = current;
                current.left = temp;
            }
            temp = current;
        }

        traverseInorder(current.right);
    }

    TreeNode binaryTreeToDLL(TreeNode root) {
        if (root == null) {
            System.out.println("Empty Tree");
            return root;
        }
        TreeNode[] head = new TreeNode[1];
        binaryTreeToDLL(root, head);
        printDLL(head[0]);

        return head[0];
    }

    void binaryTreeToDLL(TreeNode root, TreeNode[] head) {
        if (root == null) {
            return;
        }
        binaryTreeToDLL(root.right, head);
        root.right = head[0];
        if (head[0] != null) {
            head[0].left = root;
        }
        head[0] = root;

        binaryTreeToDLL(root.left, head);
    }

    public void printDLL(TreeNode root) {
        System.out.printf("The DLL Nodes are: ");
        while (root != null) {
            System.out.printf(" " + root.data);
            root = root.right;
        }
    }

    public TreeNode dLLToBinaryTree(TreeNode head) {
        if (head == null) {
            return head;
        }
        TreeNode mid = mid(head);

        if (mid.left != null) {
            mid.left.right = null;
            mid.left = dLLToBinaryTree(head);
        }
        if (mid.right != null) {
            mid.right.left = null;

            mid.right = dLLToBinaryTree(mid.right);
        }
        return mid;
    }

    public TreeNode mid(TreeNode head) {
        if (head == null || head.right == null) {
            return head;
        }

        TreeNode slow = head;
        TreeNode fast = head;

        while (fast.right != null && fast.right.right != null) {
            slow = slow.right;
            fast = fast.right.right;
        }
        return slow;
    }

    public void printView() {
        // Extract the entries of map into a set to traverse
        // an iterator over that.
        Set<Entry<Integer, Integer>> set = mapValue.entrySet();

        // Traverse the map elements using the iterator.
        for (Entry<Integer, Integer> me : set) {
            System.out.print(me.getValue() + " ");
        }
    }

    // Method that prints the bottom view.
    public void bottomView() {
        if (root == null)
            return;

        // Initialize a variable 'hd' with 0 for the root element.
        int hd = 0;

        // TreeMap which stores key value pair sorted on key value
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();

        // Queue to store tree nodes in level order traversal
        Queue<TreeNode> queue = new LinkedList<>();

        // Assign initialized horizontal distance value to root
        // node and add it to the queue.
        root.hd = hd;
        queue.add(root);

        // Loop until the queue is empty (standard level order loop)
        while (!queue.isEmpty()) {
            TreeNode temp = queue.remove();

            // Extract the horizontal distance value from the
            // dequeued tree node.
            hd = temp.hd;

            // Put the dequeued tree node to TreeMap having key
            // as horizontal distance. Every time we find a node
            // having same horizontal distance we need to replace
            // the data in the map.
            map.put(hd, temp.data);

            // If the dequeued node has a left child add it to the
            // queue with a horizontal distance hd-1.
            if (temp.left != null) {
                temp.left.hd = hd - 1;
                queue.add(temp.left);
            }
            // If the dequeued node has a left child add it to the
            // queue with a horizontal distance hd+1.
            if (temp.right != null) {
                temp.right.hd = hd + 1;
                queue.add(temp.right);
            }
        }

        // Extract the entries of map into a set to traverse
        // an iterator over that.
        Set<Entry<Integer, Integer>> set = map.entrySet();

        // Make an iterator
        Iterator<Entry<Integer, Integer>> iterator = set.iterator();

        // Traverse the map elements using the iterator.
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> me = iterator.next();
            System.out.print(me.getValue() + " ");
        }
    }
}
