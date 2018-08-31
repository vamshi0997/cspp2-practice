import java.util.Scanner;
//import java.lang.Math.sqrt;
/**
@author vamshi
*/

public final class Solution {
    /**
    @default constructor
    */
    private Solution() {
    }
    /**
    Do not modify this main function.
    @param args string
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int first = scan.nextInt();
        int second = scan.nextInt();
        int third = scan.nextInt();
        rootsOfQuadratic(first, second, third);
    }
    /**
    Need to write the rootsOfQuadraticEquation function and
    print the output.
    @param first integer
    @param second integer
    @param third integer
    */
    static void rootsOfQuadratic(final int first, final int second, final int third) {
    /*
    finding roots for equation
    */
        final int temp = 4;
        double root1 = (-second + Math.sqrt(second * second 
                        - (temp * first * third))) / (2 * first);
        double root2 = (-second - Math.sqrt(second * second 
                       - (temp * first * third))) / (2 * first);
        System.out.println(root1 + " " + root2);
    }
}
