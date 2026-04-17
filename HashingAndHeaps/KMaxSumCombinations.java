//the goal is to find the top k maximum sum combinations, where each combination is formed by adding one element from a and one from b.
//package HashingAndHeaps;
import java.util.*;

// Pair class to store sum and indices (i, j)
class Pair {
    int sum;
    int i;
    int j;

    Pair(int sum, int i, int j) {
        this.sum = sum;
        this.i = i;
        this.j = j;
    }
}

public class KMaxSumCombinations {

    public static void main(String[] args) {

        int[] a = {1, 4, 2, 3};
        int[] b = {2, 5, 1, 6};
        int k = 2;

        List<Integer> result = kMaxSum(a, b, k);

        System.out.println(result); 
    }

    public static List<Integer> kMaxSum(int[] a, int[] b, int k) {

        int n = a.length;

        /*
         * STEP 1: SORT ARRAYS IN DESCENDING ORDER
         * So that largest elements come first
         */
        Arrays.sort(a);
        Arrays.sort(b);

        reverse(a);
        reverse(b);

        /*
         * STEP 2: MAX HEAP (PRIORITY QUEUE)
         * Stores pairs in decreasing order of sum
         */
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (x, y) -> y.sum - x.sum
        );

        /*
         * STEP 3: SET TO AVOID DUPLICATE PAIRS
         * Stores visited (i, j) combinations
         */
        Set<String> visited = new HashSet<>();

        /*
         * STEP 4: START WITH LARGEST POSSIBLE SUM
         * a[0] + b[0]
         */
        pq.add(new Pair(a[0] + b[0], 0, 0));
        visited.add("0#0");

        /*
         * STEP 5: RESULT LIST
         */
        List<Integer> result = new ArrayList<>();

        /*
         * STEP 6: PROCESS TOP K ELEMENTS
         */
        while (k-- > 0) {

            // Extract maximum sum pair
            Pair curr = pq.poll();
            result.add(curr.sum);

            int i = curr.i;
            int j = curr.j;

            /*
             * STEP 7: PUSH NEXT POSSIBLE PAIRS
             */

            // Move down in array 'a' → (i+1, j)
            if (i + 1 < n && !visited.contains((i + 1) + "#" + j)) {

                int newSum = a[i + 1] + b[j];

                pq.add(new Pair(newSum, i + 1, j));

                visited.add((i + 1) + "#" + j);
            }

            // Move right in array 'b' → (i, j+1)
            if (j + 1 < n && !visited.contains(i + "#" + (j + 1))) {

                int newSum = a[i] + b[j + 1];

                pq.add(new Pair(newSum, i, j + 1));

                visited.add(i + "#" + (j + 1));
            }
        }

        return result;
    }

    /*
     * Helper function to reverse array
     * Converts ascending → descending
     */
    public static void reverse(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
}