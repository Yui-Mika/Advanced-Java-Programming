import java.util.Arrays;

public class Task1_DigitsDescending {

    // function to sort digits of a number in descending order
    public static int sortDigitsDescending(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Input must be a non-negative integer.");
        }

        // convert number to char array
        char[] digits = String.valueOf(num).toCharArray();

        Arrays.sort(digits); // sort digits ascending

        // reverse array to make it descending
        for (int i = 0, j = digits.length - 1; i < j; i++, j--) {
            char temp = digits[i];
            digits[i] = digits[j];
            digits[j] = temp;
        }

        // turn char array back to int
        return Integer.parseInt(new String(digits));
    }

    public static void main(String[] args) {
        int[] inputs = {42145, 145263}; // some test numbers
        for (int num : inputs) {
            int result = sortDigitsDescending(num);
            System.out.println("Input: " + num + " -> Output: " + result);
        }
    }
}

        