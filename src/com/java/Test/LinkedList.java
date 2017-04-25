package com.java.Test;

public class LinkedList {
    // TODO: 25/04/17 implement

    /*Reverse A Linked List

    Node reverse(Node current, Node prev){
        if(current.next == null){
            head = current;
            current.next = prev;
            return current;
        }

        Node temp = current.next;
        current.next = prev;
        reverse(temp, current);
        return head;
    }

 1->2->3->4->5->6->7->null

         3->2->1->6->5->4->7->null

    Reverse a Linked List in groups ok k nodes:
    Node reverseWithInterval(Node head, int k){
        Node current = head;
        Node next = null;
        Node prev = null;
        for(int i = 0; i < k && current != null; i++){
            next = current.next;
            current.next = prev;
            current = next;
            prev = current;
        }
        if(next != null){
            head.next = reverseWithInterval(next,k);
        }
        return prev;
    }*/
}
