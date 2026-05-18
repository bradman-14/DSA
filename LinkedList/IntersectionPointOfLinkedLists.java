//Given the head of two singly linked lists that merge at some point to form a Y-shaped structure.
//Find the node at which the two linked lists first intersect

class ListNode {

    int val;
    ListNode next;

    // Constructor
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class IntersectionPointOfLinkedLists {

    // Function to find intersection node
    public static ListNode getIntersectionNode(
            ListNode headA,
            ListNode headB) {

        // Edge case:
        // if any list is empty
        if (headA == null || headB == null) {
            return null;
        }

        // Create two pointers
        ListNode p1 = headA;
        ListNode p2 = headB;

        /*
         Move both pointers until they meet.

         If a pointer reaches the end of its list,
         redirect it to the head of the other list.

         This equalizes total distance traveled.
        */

        while (p1 != p2) {

            // Move p1
            if (p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }

            // Move p2
            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }

        /*
         Either:
         - intersection node
         OR
         - null if no intersection exists
        */
        return p1;
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

        /*
            Creating common intersecting part:

            7 -> 8 -> 9
        */

        ListNode common = new ListNode(7);
        common.next = new ListNode(8);
        common.next.next = new ListNode(9);

        /*
            Creating List A:

            1 -> 2 -> 3 -> 7 -> 8 -> 9
        */

        ListNode headA = new ListNode(1);

        headA.next = new ListNode(2);
        headA.next.next = new ListNode(3);

        // Attach common part
        headA.next.next.next = common;

        /*
            Creating List B:

            4 -> 5 -> 7 -> 8 -> 9
        */

        ListNode headB = new ListNode(4);

        headB.next = new ListNode(5);

        // Attach common part
        headB.next.next = common;

        // Print lists
        System.out.println("List A:");
        printList(headA);

        System.out.println("List B:");
        printList(headB);

        // Find intersection
        ListNode intersection =
                getIntersectionNode(headA, headB);

        // Print result
        if (intersection != null) {

            System.out.println(
                "Intersection Point: "
                + intersection.val
            );

        } else {

            System.out.println(
                "No Intersection Found"
            );
        }
    }
}