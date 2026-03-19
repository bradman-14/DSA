//Given an array of time intervals where arr[i] = [starti, endi], 
//our task is to merge all the overlapping intervals into one and output the result which should have only mutually exclusive intervals.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingIntervals {
    public static int[][] merge(int[][] intervals) {

        // STEP 1: Sort intervals based on start time
        // WHY: So that overlapping intervals come next to each other
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // This list will store the merged intervals
        // WHY: Dynamic size, since we don't know how many intervals remain after merging
        List<int[]> result = new ArrayList<>();

        // STEP 2: Traverse through each interval
        for (int[] interval : intervals) {

            // CASE 1: If result is empty → add first interval directly
            // CASE 2: If NO OVERLAP → add new interval
            // Condition for NO OVERLAP:
            // last interval's end < current interval's start
            if (result.isEmpty() || result.get(result.size() - 1)[1] < interval[0]) {
                
                // No overlap → safe to add
                result.add(interval);
            } 
            else {
                // CASE 3: OVERLAP exists
                // Example: [1,3] and [2,6]

                // Get last interval from result
                int[] lastInterval = result.get(result.size() - 1);

                // Merge by updating the END value
                // WHY: Start remains same, end becomes max of both
                lastInterval[1] = Math.max(lastInterval[1], interval[1]);
            }
        }

        // STEP 3: Convert List to 2D array
        // WHY: Return type is int[][]
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {

        // TEST CASE
        int[][] intervals = {
            {1, 3},
            {2, 6},
            {8, 10},
            {15, 18}
        };

        // Call merge function
        int[][] merged = merge(intervals);

        // Print result
        System.out.println("Merged Intervals:");
        for (int[] interval : merged) {
            System.out.println(Arrays.toString(interval));
        }
    }
}

