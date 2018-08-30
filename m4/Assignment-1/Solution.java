import java.util.Scanner;
/**
 * @author vamshi
 */
public final class Solution {
    /**
     * @brief creating default constructor for class
     * @default constructor
     */
    private Solution() {

    }
    /**
     * @details Fill this main function to print maximum of given array
     * @param args string
     */

    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int max = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] > max) {
                max = arr[j];
            }
        }
        System.out.println(max);
    }
}
