class Node {

    int data;

    Node next;
    Node child;

    // Constructor
    Node(int data) {

        this.data = data;
        this.next = null;
        this.child = null;
    }
}

public class FlattenMultilevelLinkedList {

    // Function to flatten multilevel linked list
    public static Node flattenList(Node head) {

        // Edge case
        if (head == null) {
            return null;
        }

        // -----------------------------------
        // STEP 1:
        // Find tail of first level
        // -----------------------------------

        Node tail = head;

        while (tail.next != null) {
            tail = tail.next;
        }

        /*
            tail now points to
            last node of current list
        */

        // -----------------------------------
        // STEP 2:
        // Traverse the list
        // -----------------------------------

        Node curr = head;

        while (curr != null) {

            /*
                If current node has a child,
                attach child list at tail
            */

            if (curr.child != null) {

                // Attach child list at end
                tail.next = curr.child;

                /*
                    Move tail to end
                    of newly attached child list
                */

                Node nextNode = curr.child;

                while (nextNode.next != null) {
                    nextNode = nextNode.next;
                }

                // Update tail
                tail = nextNode;

                // Remove child pointer
                curr.child = null;
            }

            // Move to next node
            curr = curr.next;
        }

        return head;
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
            Creating multilevel linked list

            1 -> 2 -> 3
            |    |
            4->5 6
               |
               7->8
        */

        Node head = new Node(1);

        head.next = new Node(2);
        head.next.next = new Node(3);

        // Child list of 1
        head.child = new Node(4);
        head.child.next = new Node(5);

        // Child list of 2
        head.next.child = new Node(6);

        // Child list of 5
        head.child.next.child = new Node(7);
        head.child.next.child.next = new Node(8);

        System.out.println("Flattened Linked List:");

        // Flatten the list
        head = flattenList(head);

        // Print flattened list
        printList(head);
    }
}