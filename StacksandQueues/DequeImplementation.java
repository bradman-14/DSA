// This code demonstrates how to implement a Stack and a Queue using a Deque (Double-Ended Queue) in Java.
package StacksandQueues;
import java.util.*;
public class DequeImplementation {

    // ---------------- STACK USING DEQUE ----------------
    static class StackUsingDeque {
        Deque<Integer> dq = new ArrayDeque<>();

        // Push → insert at front
        void push(int x) {
            dq.addFirst(x);
            System.out.println("Stack push: " + x);
        }

        // Pop → remove from front
        int pop() {
            if (dq.isEmpty()) {
                System.out.println("Stack Underflow");
                return -1;
            }
            return dq.removeFirst();
        }

        // Top → peek front
        int top() {
            if (dq.isEmpty()) return -1;
            return dq.peekFirst();
        }

        boolean isEmpty() {
            return dq.isEmpty();
        }

        void printStack() {
            System.out.println("Stack (top at front): " + dq);
        }
    }

    // ---------------- QUEUE USING DEQUE ----------------
    static class QueueUsingDeque {
        Deque<Integer> dq = new ArrayDeque<>();

        // Enqueue → insert at rear
        void enqueue(int x) {
            dq.addLast(x);
            System.out.println("Queue enqueue: " + x);
        }

        // Dequeue → remove from front
        int dequeue() {
            if (dq.isEmpty()) {
                System.out.println("Queue Underflow");
                return -1;
            }
            return dq.removeFirst();
        }

        // Front → peek front
        int front() {
            if (dq.isEmpty()) return -1;
            return dq.peekFirst();
        }

        boolean isEmpty() {
            return dq.isEmpty();
        }

        void printQueue() {
            System.out.println("Queue (front at left): " + dq);
        }
    }

    // ---------------- MAIN FUNCTION ----------------
    public static void main(String[] args) {

        // ----- STACK TEST -----
        System.out.println("=== STACK USING DEQUE ===");
        StackUsingDeque stack = new StackUsingDeque();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.printStack();

        System.out.println("Stack top: " + stack.top());

        System.out.println("Stack pop: " + stack.pop());
        stack.printStack();

        // ----- QUEUE TEST -----
        System.out.println("\n=== QUEUE USING DEQUE ===");
        QueueUsingDeque queue = new QueueUsingDeque();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.printQueue();

        System.out.println("Queue front: " + queue.front());

        System.out.println("Queue dequeue: " + queue.dequeue());
        queue.printQueue();
    }
}