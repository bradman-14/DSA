// Given an array of integers, we need to find the minimum number of merge operations required to make the array a palindrome.

class MinimumMergePalindrome {

    public static int minMergeOperations(int[] arr) {

        int left = 0;                 // start pointer
        int right = arr.length - 1;  // end pointer

        int operations = 0;          // count merges

        // Loop until pointers meet
        while (left < right) {

            // CASE 1: Already equal → move inward
            if (arr[left] == arr[right]) {
                left++;
                right--;
            }

            // CASE 2: Left is smaller → merge on left side
            else if (arr[left] < arr[right]) {

                // Merge current element with next element
                arr[left + 1] = arr[left] + arr[left + 1];

                left++;        // move pointer forward
                operations++;  // count operation
            }

            // CASE 3: Right is smaller → merge on right side
            else {

                // Merge current element with previous element
                arr[right - 1] = arr[right] + arr[right - 1];

                right--;       // move pointer backward
                operations++;  // count operation
            }
        }

        return operations;
    }

    public static void main(String[] args) {

        int[] arr = {1, 4, 5, 1};

        int result = minMergeOperations(arr);

        System.out.println("Minimum merge operations: " + result);
    }
}
