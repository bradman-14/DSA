//Given an unsorted linked list, remove duplicates from it. The nodes are not in sorted order.

import java.util.*;

class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class RemoveDuplicatesUnsortedLL {
  /*     Approach:
        ----------
        Use HashSet to track
        already visited values.
    */
    public static Node removeDuplicates(Node head) {

        if (head == null) {
            return null;
        }

        /*
            HashSet stores unique values
        */
        HashSet<Integer> set = new HashSet<>();

        Node prev = null;
        Node curr = head;

        while (curr != null) {
            /* 
                Duplicate found
            */
            if (set.contains(curr.data)) {

                /*
                    Remove current node
                */
                prev.next = curr.next;
            }
            else {

                /*
                    First occurrence
                */
                set.add(curr.data);

                /*
                    Move prev forward
                */
                prev = curr;
            }

            /*
                Move curr forward
            */
            curr = curr.next;
        }

        return head;
    }

    /*
        Print linked list
    */
    public static void printList(Node head) {

        Node temp = head;

        while (temp != null) {

            System.out.print(temp.data);

            if (temp.next != null) {
                System.out.print(" -> ");
            }

            temp = temp.next;
        }

        System.out.println();
    }

    /*
        Main function
    */
    public static void main(String[] args) {

        /*
            Creating linked list:

            12 -> 11 -> 12 -> 21 -> 41 -> 43 -> 21
        */
        Node head = new Node(12);

        head.next = new Node(11);
        head.next.next = new Node(12);
        head.next.next.next = new Node(21);
        head.next.next.next.next = new Node(41);
        head.next.next.next.next.next = new Node(43);
        head.next.next.next.next.next.next = new Node(21);

        System.out.println("Original Linked List:");
        printList(head);

        /*
            Remove duplicates
        */
        head = removeDuplicates(head);

        System.out.println("\nLinked List After Removing Duplicates:");
        printList(head);
    }
}