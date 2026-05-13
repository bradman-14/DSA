
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

public class MergeTwoSortedLists {

    /*
        Merges two sorted linked lists

        Time Complexity  : O(n + m)
        Space Complexity : O(1)

        Approach:
        ----------
        Compare nodes from both lists
        and attach smaller node each time.
    */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        /*
            Dummy node helps in easy linking
        */
        ListNode dummy = new ListNode(-1);

        /*
            temp is used to build merged list
        */
        ListNode temp = dummy;

        /*
            Traverse both lists
        */
        while (list1 != null && list2 != null) {

            /*
                Attach smaller node
            */
            if (list1.data <= list2.data) {

                temp.next = list1;
                list1 = list1.next;
            }
            else {

                temp.next = list2;
                list2 = list2.next;
            }

            /*
                Move temp forward
            */
            temp = temp.next;
        }

        /*
            Attach remaining nodes
            from list1
        */
        if (list1 != null) {
            temp.next = list1;
        }

        /*
            Attach remaining nodes
            from list2
        */
        if (list2 != null) {
            temp.next = list2;
        }

        /*
            dummy.next is head
            of merged list
        */
        return dummy.next;
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
            First sorted list:
            1 -> 3 -> 5
        */
        ListNode list1 = new ListNode(1);

        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);

        /*
            Second sorted list:
            2 -> 4 -> 6
        */
        ListNode list2 = new ListNode(2);

        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);

        System.out.println("List 1:");
        printList(list1);

        System.out.println("List 2:");
        printList(list2);

        /*
            Merge lists
        */
        ListNode mergedHead = mergeTwoLists(list1, list2);

        System.out.println("\nMerged Linked List:");
        printList(mergedHead);
    }
}