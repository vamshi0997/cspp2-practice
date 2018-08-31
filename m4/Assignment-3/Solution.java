
// Given an String, Write a java method that returns the decimal value for the given binary string.


import java.util.Scanner;
import java.lang.Math.*;
public class Solution
{/*
	Do not modify this main function.
	*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String l = sc.nextLine();
        int n = Integer.parseInt(l);
		for(int i=0; i<=n; i++) {
		    String s = sc.nextLine();
			String res = binaryToDecimal(s);//Write binaryToDecimal function
			System.out.println(res);
		}
	}

	static String binaryToDecimal(String s) {
        int n = Integer.parseInt(s);
        double sum = 0;
        int count1 = 0;
        while (n > 0) {
        	if (n%10 == 1){
        		sum = sum + Math.pow(2, count1);
        	}
        	n = n/10;
        	count1 += 1;
        }
        String sum1 = Double.toString(sum);
        return sum1;
	}

}
