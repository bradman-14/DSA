
public class MinOperationsToConvert {

    public static int minOperations(String A, String B) {

        
        // STEP 1: Check if lengths are equal
        
        // If lengths are different → not possible
        if (A.length() != B.length()) {
            return -1;
        }

        int n = A.length();

    
        // STEP 2: Check if both strings have same characters
       
        // We use frequency array to ensure both strings
        // contain same characters (just rearranged)
        int[] freq = new int[256];

        for (int i = 0; i < n; i++) {

            // Increase count for A
            freq[A.charAt(i)]++;

            // Decrease count for B
            freq[B.charAt(i)]--;
        }

        // If any value is not 0 → mismatch → not possible
        //which means Characters are different → impossible
        for (int i = 0; i < 256; i++) {
            if (freq[i] != 0) {
                return -1;
            }
        }

        
        // STEP 3: Compare from RIGHT side
     
        int i = n - 1; // pointer for A (end of A)
        int j = n - 1; // pointer for B (end of B)

        int count = 0; // number of operations

        // Traverse A from right to left
        while (i >= 0) {

          
            // CASE 1: Characters match
            
            if (A.charAt(i) == B.charAt(j)) {

                // No operation needed
                // Move both pointers towards left
                i--;
                j--;
            } 
            else {

               
                // CASE 2: Characters do NOT match
               
                // This means this character must be moved to front
                count++;

                // Move only pointer of A
                // which means we skip this character as it will be moved to front
                i--;
            }
        }

        // Return total operations required
        return count;
    }

    // -------------------------------
    // MAIN FUNCTION
    // -------------------------------
    public static void main(String[] args) {

        String A = "EACBD";
        String B = "EABCD";

        int result = minOperations(A, B);

        if (result == -1) {
            System.out.println("Not possible");
        } else {
            System.out.println("Minimum operations required: " + result);
        }
    }
}