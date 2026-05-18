//Given a linked list, rearrange it such that the converted list should be of the form a < b > c < d > e < f … where a, b, c… are consecutive data nodes of the linked list.
class Node {

    int data;
    Node next;

    // Constructor
    Node(int data) {

        this.data = data;
        this.next = null;
    }
}

public class ZigZagLinkedList {

    /*
        APPROACH:

        We traverse the linked list only once.

        We maintain a boolean flag:

        flag = true
        -> current node should be smaller than next node
           (curr < curr.next)

        flag = false
        -> current node should be greater than next node
           (curr > curr.next)

        At every adjacent pair:

        1. Check whether the required zig-zag
           condition is satisfied.

        2. If condition is violated,
           swap the data of the two nodes.

        3. Move ahead and toggle the flag.

        Example:

        Input:
        1 -> 2 -> 3 -> 4

        Step 1:
        1 < 2  ✔

        Step 2:
        Need 2 > 3 ✘
        Swap them

        List becomes:
        1 -> 3 -> 2 -> 4

        Step 3:
        Need 2 < 4 ✔

        Final Output:
        1 -> 3 -> 2 -> 4

        Time Complexity:
        O(N)

        Space Complexity:
        O(1)
    */

    // Function to rearrange linked list
    // in zig-zag fashion
    public static void zigZag(Node head) {

        // Edge case
        if (head == null || head.next == null) {
            return;
        }

        /*
            flag = true
            means current < next

            flag = false
            means current > next
        */

        boolean flag = true;

        // Start traversal
        Node curr = head;

        while (curr.next != null) {

            // --------------------------------
            // CASE 1:
            // Expect current < next
            // --------------------------------

            if (flag == true) {

                // If condition violated
                if (curr.data > curr.next.data) {

                    // Swap data
                    int temp = curr.data;
                    curr.data = curr.next.data;
                    curr.next.data = temp;
                }
            }

            // --------------------------------
            // CASE 2:
            // Expect current > next
            // --------------------------------

            else {

                // If condition violated
                if (curr.data < curr.next.data) {

                    // Swap data
                    int temp = curr.data;
                    curr.data = curr.next.data;
                    curr.next.data = temp;
                }
            }

            // Move to next node
            curr = curr.next;

            // Toggle flag
            flag = !flag;
        }
    }

    // Function to print linked list
    public static void printList(Node head) {

        Node curr = head;

        while (curr != null) {

            System.out.print(curr.data);

            if (curr.next != null) {
                System.out.print(" -> ");
            }

            curr = curr.next;
        }

        System.out.println();
    }

    // Main function
    public static void main(String[] args) {

        /*
            Creating linked list:

            1 -> 2 -> 3 -> 4
        */

        Node head = new Node(1);

        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        System.out.println("Original Linked List:");

        printList(head);

        // Rearrange in zig-zag fashion
        zigZag(head);

        System.out.println("Zig-Zag Linked List:");

        printList(head);
    }
}