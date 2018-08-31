import java.util.Scanner;
/**
 * @author vamshi
 * Do not modify this main function.
 */

public final class Solution {
    /**
     * @default constructor
     */
    private Solution() {

    }
    /* Fill the main function to print the number of 7's between 1 to n*/
    /**
     * @param args integer.
     */

    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        int result = 0;
        for (int i = 1; i < number; i++) {
            result += count(i);
            }
        System.out.println(result);
    }
    /**
     * @param number integer
     * @return integer
     */
    public static int count(final int number) {
        int count1 = 0, num1 = number;
        final int num2 = 10, num3 = 7;
        while (num1 > 0) {
            if (num1 % num2 == num3) {
                count1 += 1;
            }
            num1 = num1 / num2;
        }
        return count1;
    }
}
