/*
 * Stack with O(1) operations:
 * push, pop, findMiddle, deleteMiddle
 *
 * CORE IDEA:
 * Use a Doubly Linked List (DLL) + maintain a pointer to the middle node
 */
package StacksandQueues;
class StackWithMiddlePointer{

    /*
     * Node class for Doubly Linked List
     * Each node has:
     * - data (value)
     * - prev (pointer to previous node)
     * - next (pointer to next node)
     */
    static class Node {
        int data;
        Node prev, next;

        Node(int d) {
            this.data = d;
            this.prev = null;
            this.next = null;
        }
    }

    /*
     * Stack class with middle pointer
     */
    static class StackWithMiddle {

        Node head;   // Top of stack (like stack top)
        Node mid;    // Pointer to middle node
        int count;   // Number of elements in stack

        // Constructor → initialize empty stack
        StackWithMiddle() {
            head = null;
            mid = null;
            count = 0;
        }

        // ---------------- PUSH OPERATION ----------------
        void push(int x) {

            // Step 1: Create new node
            Node newNode = new Node(x);

            /*
             * Step 2: Insert at the beginning (top of stack)
             * This is standard stack behavior
             */
            newNode.next = head;

            // If stack is not empty, update previous pointer of old head
            if (head != null) {
                head.prev = newNode;
            }

            // Move head to new node
            head = newNode;

            // Step 3: Increase count
            count++;

            /*
             * Step 4: Update middle pointer
             */

            // If first element → mid = head
            if (count == 1) {
                mid = newNode;
            }

            /*
             * If count becomes EVEN:
             * Move mid towards TOP (prev direction)
             *
             * Why?
             * Because we are using "upper middle"
             */
            else if (count % 2 == 0) {
                mid = mid.prev;
            }

            System.out.println("Pushed: " + x);
        }

        // ---------------- POP OPERATION ----------------
        int pop() {

            // If stack empty → underflow
            if (count == 0) {
                System.out.println("Stack Underflow");
                return -1;
            }

            // Step 1: Get value of top
            int item = head.data;

            // Step 2: Move head forward (remove top)
            head = head.next;

            // If new head exists, remove backward link
            if (head != null) {
                head.prev = null;
            }

            // Step 3: Decrease count
            count--;

            /*
             * Step 4: Update middle pointer
             */

            // If stack becomes empty
            if (count == 0) {
                mid = null;
            }

            /*
             * If count becomes ODD:
             * Move mid towards BOTTOM (next direction)
             */
            else if (count % 2 != 0) {
                mid = mid.next;
            }

            return item;
        }

        // ---------------- FIND MIDDLE ----------------
        int findMiddle() {

            // If stack empty
            if (mid == null) {
                System.out.println("Stack is empty");
                return -1;
            }

            // Directly return middle → O(1)
            return mid.data;
        }

        // ---------------- DELETE MIDDLE ----------------
        void deleteMiddle() {

            // If stack empty
            if (count == 0) {
                System.out.println("Stack is empty");
                return;
            }

            System.out.println("Deleting middle: " + mid.data);

            // Case: Only one element
            if (count == 1) {
                head = null;
                mid = null;
                count = 0;
                return;
            }

            // Store middle node
            Node temp = mid;

            /*
             * Step 1: Remove middle node by fixing links
             */

            // Connect previous node to next node
            if (temp.prev != null) {
                temp.prev.next = temp.next;
            }

            // Connect next node to previous node
            if (temp.next != null) {
                temp.next.prev = temp.prev;
            }

            /*
             * Step 2: Update middle pointer
             */

            /*
             * If count is EVEN:
             * move mid DOWN (next)
             */
            if (count % 2 == 0) {
                mid = temp.next;
            }

            /*
             * If count is ODD:
             * move mid UP (prev)
             */
            else {
                mid = temp.prev;
            }

            // Step 3: Decrease count
            count--;
        }

        // ---------------- PRINT STACK ----------------
        void printStack() {

            Node curr = head;

            System.out.print("Stack: ");

            // Traverse from top to bottom
            while (curr != null) {
                System.out.print(curr.data + " ");
                curr = curr.next;
            }

            System.out.println();

            // Print middle element
            if (mid != null) {
                System.out.println("Middle: " + mid.data);
            } else {
                System.out.println("Middle: null");
            }

            System.out.println("-------------------------");
        }
    }

    // ---------------- MAIN FUNCTION ----------------
    public static void main(String[] args) {

        StackWithMiddle st = new StackWithMiddle();

        st.push(1);
        st.printStack();

        st.push(2);
        st.printStack();

        st.push(3);
        st.printStack();

        st.push(4);
        st.printStack();

        st.push(5);
        st.printStack();

        System.out.println("Current Middle: " + st.findMiddle());

        System.out.println("Popped: " + st.pop());
        st.printStack();

        st.deleteMiddle();
        st.printStack();

        st.deleteMiddle();
        st.printStack();
    }
}