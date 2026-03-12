//You are given a read only array of n integers from 1 to n.
//Each integer appears exactly once except A which appears twice and B which is missing.
//Return A and B.

class RepeatMissing {

    public static int[] findNumbers(int[] arr) {

        int n = arr.length;

        long sum = 0;
        long squareSum = 0;

        for(int i = 0; i < n; i++){
            sum += arr[i];
            squareSum += (long)arr[i] * arr[i];
        }

        long expectedSum = (long)n * (n + 1) / 2;
        long expectedSquareSum = (long)n * (n + 1) * (2*n + 1) / 6;

        long diff = sum - expectedSum;  // A - B
        long squareDiff = squareSum - expectedSquareSum; // A² - B²

        long sumAB = squareDiff / diff; // A + B

        int A = (int)((diff + sumAB) / 2);
        int B = (int)(sumAB - A);

        return new int[]{A, B};
    }

    public static void main(String[] args) {

        int[] arr = {3,1,2,5,3};

        int[] result = findNumbers(arr);

        System.out.println("Repeating: " + result[0]);
        System.out.println("Missing: " + result[1]);
    }
}