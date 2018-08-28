import java.util.Scanner;
import java.lang.Math.*;
/**
@author vamshi
*/
public final class Solution {
    /**
    Do not modify this main function.
    */
    /*
    * default constructor
    */
    private Solution() {
    }
    /**
    @param args string
    */
    public static void main(final String[] args) {
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
