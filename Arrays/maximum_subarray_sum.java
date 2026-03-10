//Given an integer array nums, find the subarray with the largest sum, and return its sum.
//Kadane's Algorithm
public class maximum_subarray_sum {
     public int maxSubArray(int[] nums) {
        int maxSum = nums[0];      // max sum so far
        int currentSum = 0;        // current running sum

        for (int num : nums) {
            if (currentSum < 0) {
                currentSum = 0;    // reset if sum is negative
            }
            currentSum += num;
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}

