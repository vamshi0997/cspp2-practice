import java.util.Scanner;
/**
 * Do not modify this main function.
 * @author vamshi
 */
public final class Solution {
    /**
     * @details default constructor.
     */
    private Solution() {

    }
    /**
     * @param args string
     */

    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        System.out.println(gcd(num1, num2));
    }
    /**
     * @param num1 integer
     * @param num2 integer
     * @return integer
     */
    public static int gcd(final int num1, final int num2) {
        if (num1 == 1 || num2 == 1) {
            return 1;
        } else if (num1 == num2) {
            return num1;
          } else if (num1 > num2) {
               return gcd(num1 - num2, num2);
            } else if (num1 < num2) {
               return gcd(num2 - num1, num1);
              }
        return 0;
    }
}
