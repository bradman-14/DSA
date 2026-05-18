class ListNode {

    int val;
    ListNode next;

    // Constructor
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class ReorderList {

    // Function to reorder linked list
    public static void reorderList(ListNode head) {

        // Edge case
        if (head == null || head.next == null) {
            return;
        }

        // -----------------------------------
        // STEP 1: Find middle of linked list
        // -----------------------------------

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        // slow is now at middle

        // -----------------------------------
        // STEP 2: Reverse second half
        // -----------------------------------

        ListNode secondHalf = slow.next;

        // Break the list into two halves
        slow.next = null;

        ListNode prev = null;
        ListNode curr = secondHalf;

        while (curr != null) {

            ListNode nextNode = curr.next;

            curr.next = prev;

            prev = curr;

            curr = nextNode;
        }

        // prev becomes head of reversed half
        secondHalf = prev;

        // -----------------------------------
        // STEP 3: Merge alternately
        // -----------------------------------

        ListNode firstHalf = head;

        while (secondHalf != null) {

            // Store next pointers
            ListNode temp1 = firstHalf.next;
            ListNode temp2 = secondHalf.next;

            // Merge nodes
            firstHalf.next = secondHalf;
            secondHalf.next = temp1;

            // Move pointers ahead
            firstHalf = temp1;
            secondHalf = temp2;
        }
    }

    // Function to print linked list
    public static void printList(ListNode head) {

        ListNode temp = head;

        while (temp != null) {

            System.out.print(temp.val);

            if (temp.next != null) {
                System.out.print(" -> ");
            }

            temp = temp.next;
        }

        System.out.println();
    }

    // Main function
    public static void main(String[] args) {

        // Create linked list:
        // 1 -> 2 -> 3 -> 4 -> 5

        ListNode head = new ListNode(1);

        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original Linked List:");
        printList(head);

        // Reorder list
        reorderList(head);

        System.out.println("Reordered Linked List:");
        printList(head);
    }
}