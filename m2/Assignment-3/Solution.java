import java.util.Scanner;
import java.lang.Math.*;

public class Solution {
    /**
    Do not modify this main function.
    */

    /**
    * default constructor
    */
    private Solution() {

    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);      
        int base = s.nextInt();
        int exponent = s.nextInt();
        long result = power(base, exponent);
        System.out.println(result);
    }
    /**
    Need to write the power function and print the output.
    @param base integer
    @param exponent integer
    @return power()
    **/
    static long power(final int base, final int exponent) {
        if (exponent == 0) {
            return 1;
            } else {
            return base * power(base, (exponent - 1));
            }
    }
}
