//package StacksandQueues;
import java.util.*;

/*
 * Class that implements TWO stacks using ONE array
 */
class TwoStacks {

    int[] arr;     // Shared array for both stacks
    int size;      // Size of array

    int top1;      // Top of Stack 1 (grows from left → right)
    int top2;      // Top of Stack 2 (grows from right → left)

    // Constructor
    TwoStacks(int n) {
        size = n;
        arr = new int[n];

        // Initialize pointers
        top1 = -1;   // Stack 1 starts before index 0
        top2 = n;    // Stack 2 starts after last index
    }

    // ---------------- PUSH OPERATIONS ----------------

    /*
     * Push element into Stack 1
     */
    void push1(int x) {

        /*
         * Check if space is available
         * Condition ensures stacks DO NOT overlap
         */
        if (top1 < top2 - 1) {

            // Move top1 forward
            top1++;

            // Insert element
            arr[top1] = x;

            System.out.println("Pushed " + x + " into Stack1");

        } else {
            // No space left
            System.out.println("Stack Overflow in Stack1");
        }
    }

    /*
     * Push element into Stack 2
     */
    void push2(int x) {

        /*
         * Same space check
         */
        if (top1 < top2 - 1) {

            // Move top2 backward
            top2--;

            // Insert element
            arr[top2] = x;

            System.out.println("Pushed " + x + " into Stack2");

        } else {
            System.out.println("Stack Overflow in Stack2");
        }
    }

    // ---------------- POP OPERATIONS ----------------

    /*
     * Pop element from Stack 1
     */
    int pop1() {

        /*
         * Check if Stack1 is not empty
         */
        if (top1 >= 0) {

            // Get element at top
            int x = arr[top1];

            // Move pointer backward
            top1--;

            return x;

        } else {
            System.out.println("Stack1 Underflow");
            return -1;
        }
    }

    /*
     * Pop element from Stack 2
     */
    int pop2() {

        /*
         * Check if Stack2 is not empty
         */
        if (top2 < size) {

            int x = arr[top2];

            // Move pointer forward
            top2++;

            return x;

        } else {
            System.out.println("Stack2 Underflow");
            return -1;
        }
    }

    // ---------------- DISPLAY FUNCTION ----------------

    /*
     * Utility function to display current array
     * Helps visualize how both stacks share space
     */
    void printArray() {
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("top1 = " + top1 + ", top2 = " + top2);
        System.out.println("----------------------------------");
    }
}

/*
 * Main class to test TwoStacks
 */
public class Two_Stacks {

    public static void main(String[] args) {

        // Create TwoStacks with size 6
        TwoStacks ts = new TwoStacks(6);

        // Perform operations
        ts.push1(10);
        ts.printArray();

        ts.push2(20);
        ts.printArray();

        ts.push1(30);
        ts.printArray();

        ts.push2(40);
        ts.printArray();

        ts.push1(50);
        ts.printArray();

        ts.push2(60);
        ts.printArray();

        // Try overflow
        ts.push1(70);

        // Pop operations
        System.out.println("Popped from Stack1: " + ts.pop1());
        System.out.println("Popped from Stack2: " + ts.pop2());

        ts.printArray();
    }
}