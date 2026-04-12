//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
// The solution set must not contain duplicate triplets.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threesumsolution {
     public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        // Step 1: Sort the array
        // Sorting helps us use the two-pointer technique
        Arrays.sort(nums);

        /*
        Example:
        [-1,0,1,2,-1,-4]
    
        After sorting:
        [-4,-1,-1,0,1,2]
        */

        // Step 2: Fix one element and find the other two
        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate values for the first number
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            /*
            Now we fix nums[i]
            and find two numbers whose sum = -nums[i]
            */

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                /*
                Case 1: We found a valid triplet
                */
                if (sum == 0) {

                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    /*
                    Move both pointers
                    and skip duplicates
                    */
                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1])
                        left++;

                    while (left < right && nums[right] == nums[right + 1])
                        right--;
                }

                /*
                Case 2: Sum is too small
                Move left pointer to increase sum
                */
                else if (sum < 0) {
                    left++;
                }

                /*
                Case 3: Sum is too large
                Move right pointer to decrease sum
                */
                else {
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {-1,0,1,2,-1,-4};

        List<List<Integer>> ans = threeSum(nums);

        System.out.println(ans);
    }
}