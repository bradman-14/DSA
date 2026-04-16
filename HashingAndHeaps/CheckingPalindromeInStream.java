// Given a stream of characters, we need to check if the string formed by the characters read so far is a palindrome or not. We will use hashing to achieve this efficiently.
class CheckingPalindromeInStream {

    // Base is like "10" in numbers, but for characters we use 31
    static final int BASE = 31;

    public static void checkPalindromeStream(String stream) {

        // This will store the forward-built number (like 123)
        long forwardHash = 0;

        // This will store the reverse-built number (like 321)
        long reverseHash = 0;

        // This helps in placing digits correctly (1, 31, 31^2, ...)
        long power = 1;

        // Process each character one by one (like a stream)
        for (int i = 0; i < stream.length(); i++) {

            // Convert character to number
            // a=1, b=2, c=3 ...
            int val = stream.charAt(i) - 'a' + 1;

            // FORWARD HASH
            // Same as: num = num * 10 + digit
            // Here: base = 31 instead of 10
            forwardHash = forwardHash * BASE + val;

            // REVERSE HASH
            // Same as: rev = rev + digit * power
            reverseHash = reverseHash + val * power;

            // Update power (like 10^0, 10^1, 10^2 → here 31^0, 31^1, ...)
            power = power * BASE;

            // CHECK PALINDROME
            // If forward == reverse → string is palindrome
            if (forwardHash == reverseHash) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    public static void main(String[] args) {

        String stream = "ababa";

        // Call function
        checkPalindromeStream(stream);
    }
}