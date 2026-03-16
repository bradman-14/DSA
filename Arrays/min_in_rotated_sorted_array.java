//Given the sorted rotated array nums of unique elements, return the minimum element of this array.

class Solution {
      public int findMin(int[] nums) {

        // left pointer at start of array
        int left = 0;

        // right pointer at end of array
        int right = nums.length - 1;

        // Binary search until both pointers meet
        while (left < right) {

            // Find middle index
            int mid = left + (right - left) / 2;

            /*
            Compare middle element with the rightmost element

            If nums[mid] > nums[right]
            → minimum is on the RIGHT side
            Example:
            [3,4,5,1,2]
                 mid   right
            */

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }

            /*
            Otherwise minimum is on the LEFT side
            (including mid)

            Example:
            [1,2,3,4,5]
                 mid
            */

            else {
                right = mid;
            }
        }

        // When left == right we found the minimum
        return nums[left];
    }
}

public class min_in_rotated_sorted_array {

    public static void main(String[] args) {

        Solution sol = new Solution();

        int[] nums1 = {3,4,5,1,2};
        int[] nums2 = {4,5,6,7,0,1,2};
        int[] nums3 = {11,13,15,17};

        System.out.println("Minimum: " + sol.findMin(nums1));
        System.out.println("Minimum: " + sol.findMin(nums2));
        System.out.println("Minimum: " + sol.findMin(nums3));
    }
}