
/* Given an String,
Write a java method that returns the decimal value for the given binary string.*/

import java.util.Scanner;
//import java.lang.Math.*;
/**
 * @author vamshi
 */
public final class Solution {
  /**
   * @default constructor.
   */
  private Solution() {

  }
  /**
   * intializing main method.
   * @param args string
   */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String temp = sc.nextLine();
        int number = Integer.parseInt(temp);
        for (int i = 0; i <= number - 1; i++) {
            String str = sc.nextLine();
            String res = binaryToDecimal(str);
            System.out.println(res);
        }
    }
    /**
     * @param str string
     * @return string
     */
    static String binaryToDecimal(final String str) {
        Long number = Long.parseLong(str);
        final int num1 = 10;
        double sum = 0;
        int count1 = 0;
        while (number > 0) {
            if (number % num1 == 1) {
                sum = sum + Math.pow(2, count1);
            }
            number = number / num1;
            count1 += 1;
        }
        String sum1 = Integer.toString((int) sum);
        return sum1;
    }

}
