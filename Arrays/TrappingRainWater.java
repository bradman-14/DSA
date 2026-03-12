import java.util.*;

class TrappingRainWater {

    public static int trap(int[] bars) {

        int n = bars.length;

        // Base case
        if (n <= 2) {
            return 0;
        }

        int water = 0;

        // left[i] stores the maximum bar height to the left of i
        int[] left = new int[n];
        left[0] = Integer.MIN_VALUE;

        // Build left max array
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], bars[i - 1]);
        }

        // right max variable
        int right = Integer.MIN_VALUE;

        // Traverse from right to left
        for (int i = n - 2; i >= 1; i--) {

            right = Math.max(right, bars[i + 1]);

            int minHeight = Math.min(left[i], right);

            if (minHeight > bars[i]) {
                water += minHeight - bars[i];
            }
        }

        return water;
    }

    public static void main(String[] args) {

        int[] bars = {4,2,0,3,2,5};

        int result = trap(bars);

        System.out.println("Total water trapped: " + result);
    }
}