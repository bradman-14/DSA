//Given a linked list of 0s, 1s and 2s, sort it in ascending order.
class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Sort_0_1_2_LinkedList {

   /*   Approach:
        1. Count 0s, 1s and 2s
        2. Replace node values
           in sorted order
    */
    public static Node sortList(Node head) {

        /*
            Counters for
            0s, 1s and 2s
        */
        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;

        Node temp = head;

        /*
            STEP 1:
            Count occurrences
        */
        while (temp != null) {

            if (temp.data == 0) {
                zeroCount++;
            }
            else if (temp.data == 1) {
                oneCount++;
            }
            else {
                twoCount++;
            }

            temp = temp.next;
        }

        /*
            STEP 2:
            Replace values
            in sorted order
        */
        temp = head;

        /*
            Fill all 0s
        */
        while (zeroCount > 0) {

            temp.data = 0;

            temp = temp.next;
            zeroCount--;
        }

        /*
            Fill all 1s
        */
        while (oneCount > 0) {

            temp.data = 1;

            temp = temp.next;
            oneCount--;
        }

        /*
            Fill all 2s
        */
        while (twoCount > 0) {

            temp.data = 2;

            temp = temp.next;
            twoCount--;
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

        System.out.println(" -> NULL");
    }

    /*
        Main function
    */
    public static void main(String[] args) {

        /*
            Creating linked list:

            1 -> 1 -> 2 -> 0 -> 2 -> 0 -> 1
        */
        Node head = new Node(1);

        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(0);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(0);
        head.next.next.next.next.next.next = new Node(1);

        System.out.println("Original Linked List:");
        printList(head);

        /*
            Sort linked list
        */
        head = sortList(head);

        System.out.println("\nSorted Linked List:");
        printList(head);
    }
}