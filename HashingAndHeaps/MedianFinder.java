// Design a data structure that supports adding numbers and finding the median efficiently. The data structure should have the following methods:
// 1. addNum(int num): Add a number to the data structure.
// 2. findMedian(): Return the median of all elements added so far.
// 3. double findMedian(): Returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.

import java.util.*;

class MedianFinder {

    // 🔹 Max Heap → stores smaller half
    PriorityQueue<Integer> maxHeap;

    // 🔹 Min Heap → stores larger half
    PriorityQueue<Integer> minHeap;

    // 🔹 Constructor
    public MedianFinder() {

        // Max heap (largest element at top)
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Min heap (smallest element at top)
        minHeap = new PriorityQueue<>();
    }

    // 🔹 Add a number to data structure
    public void addNum(int num) {

        // Step 1: Add to maxHeap (assume it belongs to smaller half)
        maxHeap.add(num);

        // Step 2: Move largest from maxHeap → minHeap
        // This ensures ordering (left ≤ right)
        minHeap.add(maxHeap.poll());

        // Step 3: Balance heaps
        // maxHeap should always have equal or 1 more element than minHeap
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    // 🔹 Find median
    public double findMedian() {

        // If both heaps have same size → average of tops
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }

        // If not equal → maxHeap has one extra element
        return maxHeap.peek();
    }

    // 🔹 MAIN FUNCTION (Testing)
    public static void main(String[] args) {

        MedianFinder mf = new MedianFinder();

        // Adding numbers
        mf.addNum(1);
        System.out.println("Median: " + mf.findMedian()); // 1

        mf.addNum(5);
        System.out.println("Median: " + mf.findMedian()); // 3.0

        mf.addNum(3);
        System.out.println("Median: " + mf.findMedian()); // 3

        mf.addNum(8);
        System.out.println("Median: " + mf.findMedian()); // 4.0

        mf.addNum(2);
        System.out.println("Median: " + mf.findMedian()); // 3
    }
}