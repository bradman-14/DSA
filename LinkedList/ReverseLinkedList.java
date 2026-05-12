

class ListNode {

    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ReverseLinkedList {

    /*
        Reverses the linked list

        Time Complexity  : O(n)
        Space Complexity : O(1)

        Approach:
        ----------
        Use 3 pointers:
        1. prev  -> previous node
        2. curr  -> current node
        3. next  -> stores next node temporarily

        Reverse links one by one.
    */
    public static ListNode reverseList(ListNode head) {

        /*
            prev initially points to null
        */
        ListNode prev = null;

        /*
            curr starts from head
        */
        ListNode curr = head;

        while (curr != null) {

            /*
                Store next node
            */
            ListNode nextNode = curr.next;

            /*
                Reverse current link
            */
            curr.next = prev;

            /*
                Move prev forward
            */
            prev = curr;

            /*
                Move curr forward
            */
            curr = nextNode;
        }

        /*
            prev becomes new head
        */
        return prev;
    }

    /*
        Print linked list
    */
    public static void printList(ListNode head) {

        ListNode temp = head;

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
            1 -> 2 -> 3 -> 4 -> 5
        */
        ListNode head = new ListNode(1);

        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original Linked List:");
        printList(head);

        /*
            Reverse linked list
        */
        head = reverseList(head);

        System.out.println("\nReversed Linked List:");
        printList(head);
    }
}