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
    public static void main(final String[] args) {

        Scanner s = new Scanner(System.in);      
        int n = s.nextInt();
        int r = 0;
        for (int i = 1; i < n; i++) {
            r += count(i);
            }
        System.out.println(r);
    }
    /**
     * @param i integer
     * @return integer
     */
    public static int count(int i) {
        int count1 = 0;
        while (i > 0) {
            if (i % 10 == 7) {
                count1 += 1;
            }
            i = i / 10;
        }
        return count1;
    }
}
