import java.util.Arrays;

public class LargestConcatenatedNumber {
     public static String largestNumber(int[] nums) {

        // STEP 1: Convert integers to strings
        // WHY: So we can concatenate and compare
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        // STEP 2: Custom sorting
        // Compare based on (b+a) vs (a+b)
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        // STEP 3: Edge case
        // If highest number is "0", then all are zeros
        if (arr[0].equals("0")) {
            return "0";
        }

        // STEP 4: Build result
        StringBuilder result = new StringBuilder();
        for (String s : arr) {
            result.append(s);
        }

        return result.toString();
    }

    public static void main(String[] args) {

        int[] nums = {3, 30, 34, 5, 9};

        String result = largestNumber(nums);

        System.out.println("Largest Number: " + result);
    }
}

