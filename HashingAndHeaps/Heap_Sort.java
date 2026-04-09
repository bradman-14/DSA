package HashingAndHeaps;
import java.util.*;

public class Heap_Sort{
    // Function to heapify subtree rooted at index i
    public static void heapify(int[] arr, int n, int i) {

        int largest = i;        // assume root is largest
        int left = 2*i + 1;     // left child
        int right = 2*i + 2;    // right child

        // If left child is bigger
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child is bigger
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root → swap
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Recursively heapify affected subtree
            heapify(arr, n, largest);
        }
    }

    public static void heapSort(int[] arr) {

        int n = arr.length;

        // --------------------------
        // STEP 1: Build Max Heap
        // --------------------------
        for (int i = n/2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // --------------------------
        // STEP 2: Extract elements
        // --------------------------
        for (int i = n-1; i > 0; i--) {

            // Move root (max) to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify reduced heap
            heapify(arr, i, 0);
        }
    }

    public static void main(String[] args) {

        int[] arr = {4, 10, 3, 5, 1};

        heapSort(arr);

        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(arr));
    }
}