import java.util.Arrays;

class PrintAllDuplicatesInTheString {

    static void printDuplicates(String s) {

        // Convert string to char array
        char[] arr = s.toCharArray();

        // Sort the array
        Arrays.sort(arr);

        // Traverse the sorted array
        for (int i = 0; i < arr.length; ) {

            int count = 1;

            // Count duplicates
            while (i + count < arr.length && arr[i] == arr[i + count]) {
                count++;
            }

            // Print only if duplicate
            if (count > 1) {
                System.out.println("[" + arr[i] + ", " + count + "]");
            }

            // Move to next new character
            i += count;
        }
    }

    public static void main(String[] args) {
        String s = "geeksforgeeks";

        printDuplicates(s);
    }
}