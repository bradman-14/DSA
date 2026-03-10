//if array contains duplicate elements, return true. Otherwise, return false.

import java.util.Arrays;

class contains_duplicate {

    public static boolean containsDuplicate(int[] nums) {

        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == nums[i+1]){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 1};

        boolean result = containsDuplicate(nums);

        System.out.println(result);
    }
}