
/*
    Node class
*/
class ListNode {

    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class RemoveLoopInLinkedList {

    /*
        Removes loop from linked list

        Time Complexity  : O(n)
        Space Complexity : O(1)

        Approach:
        ----------
        1. Detect loop using slow & fast pointers
        2. Find starting point of loop
        3. Break the loop
    */
    public static void removeLoop(ListNode head) {

        /*
            No loop possible
        */
        if (head == null || head.next == null) {
            return;
        }

        /*
            STEP 1:
            Detect loop
        */
        ListNode slow = head;
        ListNode fast = head;

        boolean hasLoop = false;

        while (fast != null && fast.next != null) {

            /*
                slow -> 1 step
                fast -> 2 steps
            */
            slow = slow.next;
            fast = fast.next.next;

            /*
                Meeting means loop exists
            */
            if (slow == fast) {

                hasLoop = true;
                break;
            }
        }

        /*
            No loop found
        */
        if (!hasLoop) {
            return;
        }

        /*
            STEP 2:
            Find start of loop
        */
        slow = head;

        /*
            Special case:
            Loop starts from head
        */
        if (slow == fast) {

            /*
                Reach last node of loop
            */
            while (fast.next != slow) {
                fast = fast.next;
            }
        }
        else {

            /*
                Move both pointers one step at a time
                the place where both slow and fast meet is starting point of loop
                until next nodes become same
            */
            while (slow.next != fast.next) {

                slow = slow.next;
                fast = fast.next;
            }
        }

        /*
            STEP 3:
            Break loop
        */
        fast.next = null;
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

        /*
            Creating loop:
            5 -> 3
        */
        head.next.next.next.next.next = head.next.next;

        /*
            Remove loop
        */
        removeLoop(head);

        System.out.println("Linked List After Removing Loop:");

        printList(head);
    }
}