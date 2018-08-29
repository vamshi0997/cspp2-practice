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
        Scanner s = new Scanner(System.in);
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        System.out.println(gcd(n1, n2));
    }
    /**
     * @param a integer
     * @param b integer
     * @return integer
     */
    public static int gcd(final int a, final int b) {
        if (a == 1 || b == 1) {
            return 1;
        } else if (a == b) {
            return a;
          } else if (a > b) {
               return gcd(a - b, b);
            } else if (a < b) {
               return gcd(b - a, a);
              }
        return 0;
    }
}
