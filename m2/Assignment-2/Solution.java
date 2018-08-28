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
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        rootsOfQuadraticEquation(a, b, c);
    }
    /**
    Need to write the rootsOfQuadraticEquation function and
    print the output.
    @param a integer
    @param b integer
    @param c integer
    */
    static void rootsOfQuadraticEquation(final int a, final int b, final int c) {
    /*
    finding roots for equation
    */
        double root1 = (-b + Math.sqrt(b * b - (4 * a * c))) / (2 * a);
        double root2 = (-b - Math.sqrt(b * b - (4 * a * c))) / (2 * a);
        System.out.println(root1 + " " + root2);
    }
}
