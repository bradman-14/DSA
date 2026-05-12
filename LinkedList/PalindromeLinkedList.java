// Problem: Check if Linked List is Palindrome
class ListNode {

    int data;
    ListNode next;

    
    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class PalindromeLinkedList {

    /*
        TIME COMPLEXITY  -> O(n)
        SPACE COMPLEXITY -> O(1)

        APPROACH:
        ----------
        1. Find middle of linked list
        2. Reverse second half
        3. Compare first half and reversed second half
    */
    public static boolean isPalindrome(ListNode head) {

        /*
            Empty list or single node
            is always palindrome
        */
        if (head == null || head.next == null) {
            return true;
        }

        /*
            ------------------------------------------------
            STEP 1 : FIND MIDDLE USING SLOW & FAST POINTERS
            ------------------------------------------------

            slow moves 1 step
            fast moves 2 steps

            When fast reaches end,
            slow reaches middle.
        */
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        /*
            Example:

            1 -> 2 -> 3 -> 2 -> 1

            slow will stop at node 3
        */

        /*
            ------------------------------------------------
            STEP 2 : REVERSE SECOND HALF
            ------------------------------------------------

            slow is currently at middle node.

            We reverse the linked list
            starting from slow.
        */
        /*
            prev will eventually become
            the head of reversed linked list.
        */
        ListNode prev = null;
        
        /*
            curr is used to traverse
            second half.
        */
        ListNode curr = slow;

        while (curr != null) {

            /*
                Store next node temporarily.

                This is important because
                after reversing link,
                original next connection
                would be lost.
            */
            ListNode nextNode = curr.next;

            /*
                Reverse current node's pointer.

                Example:

                Before:
                2 -> 1

                After:
                2 <- 1
            */
            curr.next = prev;

            /*
                Move prev forward.

                prev always points to
                the head of reversed portion.
            */
            prev = curr;

            /*
                Move curr forward
                using saved nextNode.
            */
            curr = nextNode;
        }

        /*
            After reversal:

            Original second half:
            3 -> 2 -> 1

            Reversed:
            1 -> 2 -> 3

            prev now points to:
            1 -> 2 -> 3
        */

        /*
            ------------------------------------------------
            STEP 3 : COMPARE BOTH HALVES
            ------------------------------------------------
        */

        /*
            left starts from beginning
            of original linked list
        */
        ListNode left = head;

        /*
            right starts from beginning
            of reversed second half

            prev is head of reversed list
        */
        ListNode right = prev;

        /*
            Compare node values one by one
        */
        while (right != null) {

            /*
                If values mismatch,
                linked list is not palindrome
            */
            if (left.data != right.data) {
                return false;
            }

            /*
                Move both pointers ahead
            */
            left = left.next;
            right = right.next;
        }

        /*
            All values matched
        */
        return true;
    }

    /*
        Utility function to print linked list
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

            1 -> 2 -> 3 -> 2 -> 1
        */
        ListNode head = new ListNode(1);

        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        System.out.println("Linked List:");
        printList(head);

        /*
            Check whether palindrome
        */
        boolean result = isPalindrome(head);

        System.out.println("\nIs Palindrome? " + result);
    }
}