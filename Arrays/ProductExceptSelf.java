//Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

import java.util.Arrays;

class ProductExceptSelf {

    public static int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        int[] leftProduct = new int[n];
        int[] rightProduct = new int[n];
        int[] result = new int[n];

        // Left products
        leftProduct[0] = 1;

        for(int i = 1; i < n; i++){
            leftProduct[i] = leftProduct[i-1] * nums[i-1];
        }

        // Right products
        rightProduct[n-1] = 1;

        for(int i = n-2; i >= 0; i--){
            rightProduct[i] = rightProduct[i+1] * nums[i+1];
        }

        // Multiply
        for(int i = 0; i < n; i++){
            result[i] = leftProduct[i] * rightProduct[i];
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1,2,3,4};

        int[] result = productExceptSelf(nums);

        System.out.println(Arrays.toString(result));
    }
}