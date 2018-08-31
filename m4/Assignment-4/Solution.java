
// Given an String, 
//Write a java method that returns the
//decimal value for the given binary string.


import java.util.Scanner;
/**
 * @author vamshi
 */
public final class Solution {
	/**
	 * @default constructor
	 */
	private Solution() {

	}
    /**
     * reading input in main function
     * @param args string
     */   
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String reverse=reverseString(str);	
		System.out.println(reverse);
		
	}
	/**
	 * Write reverseString function.
	 * @param str string
	 * @return string
	 */
	static String reverseString(final String str) {
		String ret = "";
		for (int i=0; i < str.length(); i++) {
			ret = str.charAt(i) + ret;
		}
	    return ret;
	}

}
