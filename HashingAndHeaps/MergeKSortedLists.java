//You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
// Merge all the linked-lists into one sorted linked-list and return it.
import java.util.*;

// 🔹 Definition of Linked List Node
class ListNode {
    int val;          // stores value
    ListNode next;    // pointer to next node

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class MergeKSortedLists {

    public static ListNode mergeKLists(ListNode[] lists) {

        // 🔥 Min Heap → always gives smallest node
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );

        // 🔹 Add first node of each list to heap
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        // 🔹 Dummy node (helps avoid edge cases)
        ListNode dummy = new ListNode(0);

        // Tail pointer to build result list
        ListNode tail = dummy;

        // 🔁 Process until heap becomes empty
        while (!pq.isEmpty()) {

            // 🔹 Get smallest node
            ListNode smallest = pq.poll();

            // 🔹 Attach it to result list
            tail.next = smallest;

            // Move tail forward
            tail = tail.next;

            // 🔥 If next node exists → push into heap
            if (smallest.next != null) {
                pq.add(smallest.next);
            }
        }

        // 🔹 Return merged list (skip dummy)
        return dummy.next;
    }

    public static void main(String[] args) {

        // 🔹 Manually creating List1: 1 → 4 → 5
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        // 🔹 List2: 1 → 3 → 4
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        // 🔹 List3: 2 → 6
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        // 🔹 Store all lists in array
        ListNode[] lists = {l1, l2, l3};

        // 🔹 Call merge function
        ListNode result = mergeKLists(lists);

        // 🔹 Print merged list
        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
    }
}