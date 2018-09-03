import java.util.*;
import java.lang.*;
/**
 * @author vamshi
 */
class InputValidator {
    /*Write the atrributes and methods for InputValidator*/
    String str1;
    int length = str1.length();
    final int six = 6;
    /**
     * @param str string
     */
    public InputValidator(String str){
        str1 = str;
    }
    /**
     * @return boolean
     */
    public boolean validateData() {
        if (length >= six) {
            return true;
        } else {
            return false;
        }

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
