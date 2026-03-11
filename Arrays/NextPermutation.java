//The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

import java.util.Arrays;

class NextPermutation {

    public static void nextPermutation(int[] nums) {

        int n = nums.length;

        // STEP 1: Find the pivot
        int pivot = -1;

        for(int i = n - 2; i >= 0; i--) {
            if(nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }

        // STEP 2: Find element just greater than pivot and swap
        if(pivot != -1) {

            for(int i = n - 1; i > pivot; i--) {
                if(nums[i] > nums[pivot]) {

                    int temp = nums[i];
                    nums[i] = nums[pivot];
                    nums[pivot] = temp;

                    break;
                }
            }
        }

        // STEP 3: Reverse the right side
        int left = pivot + 1;
        int right = n - 1;

        while(left < right) {

            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {

        int[] nums = {1,3,5,4,2};

        nextPermutation(nums);

        System.out.println(Arrays.toString(nums));
    }
}
