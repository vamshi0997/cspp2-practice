import java.util.Scanner;
//import java.lang.*;
/**
 * @author vamshi
 */
class InputValidator {
    String str1;
    /**
     * @breif constructor.
     * @param str string
     */
    InputValidator(final String str) {
        str1 = str;
    }
    /**
     * @return boolean
     */
    public boolean validateData() {
        final int six = 6;
        if (str1.length() >= six) {
            return true;
        }
        return false;

    }
}
/**
 * main class.
 */
public final class Solution {
    /**
     * @default constructor
     */
    private Solution() {

    }
    /**
     * In main method.
     * @param args string
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        InputValidator i = new InputValidator(input);
        System.out.println(i.validateData());

    }

}
