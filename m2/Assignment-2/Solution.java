import java.util.Scanner;
import java.lang.Math.*;


public class Solution {
    /*
    Do not modify this main function.
    */
    public static void main(final String[] args) {
    /*
    scanner class is used to take a, b, c input
    */
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		rootsOfQuadraticEquation(a, b, c);
	}
	/*
	Need to write the rootsOfQuadraticEquation function and
	print the output.
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
