import java.util.Scanner;
/**
 * Write a java program to find the odd composite numbers
 * between 2 and n where n is given as an input.
 *
 * @author : vamshi
 */
public final class Solution {
    /**
    * Empty constructor.
    */
    private Solution() {
        //not used
    }
    /**
     * Prints the odd composite numbers between 2 and n.
     * @param num integer
     */
    static void oddComposites(final int num) {
    // write your code here
        for (int i = 1; i < num; i++) {
            int count1 = 0;
            if (i % 2 != 0) {
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        count1 += 1;
                    }
                }
                if (count1 >= 1) {
                    System.out.println(i);
                }
            }
        }

    }
    /**
    * main method as driver program.
    * @param args is the parameter for this method
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        oddComposites(num);
    }
}
