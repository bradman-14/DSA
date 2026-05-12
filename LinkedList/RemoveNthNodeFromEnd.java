
// Problem: Remove Nth Node From End of List
class ListNode {

    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class RemoveNthNodeFromEnd {

    /*
        APPROACH USED:
        ----------------
        1. Find size of linked list
        2. Find position of node from beginning
        3. Reach previous node
        4. Remove node using:
               prev.next = prev.next.next
    */
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        /*
            Edge Case:
            If list contains only one node

            Example:
            1

            Removing 1st node from end
            results in empty list.
        */
        if (head.next == null) {
            return null;
        }

        /*
            STEP 1:
            Find size of linked list
        */
        int size = 0;

        ListNode curr = head;

        while (curr != null) {

            curr = curr.next;
            size++;
        }

        /*
            If n equals size,
            it means head node has to be removed.

            Example:
            1 -> 2 -> 3
            n = 3

            Remove node 1
        */
        if (n == size) {
            return head.next;
        }

        /*
            STEP 2:
            Find index of node from beginning

            Example:
            List size = 5
            n = 2

            Node to remove from beginning:
            5 - 2 = 3rd node
        */
        int indexToSearch = size - n;

        /*
            prev pointer is used to reach
            the node just before the node
            that must be deleted.
        */
        ListNode prev = head;

        /*
            i starts from 1 because
            head is considered position 1
        */
        int i = 1;

        /*
            Move prev until it reaches
            node before the target node
        */
        while (i < indexToSearch) {

            prev = prev.next;
            i++;
        }

        /*
            STEP 3:
            Remove target node

            prev.next         -> node to delete
            prev.next.next    -> node after deleted node

            Link prev directly to next node.
        */
        prev.next = prev.next.next;

        /*
            Return updated linked list
        */
        return head;
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

            1 -> 2 -> 3 -> 4 -> 5
        */
        ListNode head = new ListNode(1);

        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original Linked List:");
        printList(head);

        int n = 2;

        /*
            Remove 2nd node from end
        */
        head = removeNthFromEnd(head, n);

        System.out.println("\nLinked List After Removing "
                           + n + "th Node From End:");

        printList(head);
    }
}