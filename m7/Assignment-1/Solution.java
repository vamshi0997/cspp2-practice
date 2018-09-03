import java.util.*;
import java.lang.*;

class InputValidator
{
	/*Write the atrributes and methods for InputValidator*/
	String str1;
    public InputValidator(String str){
        str1 = str;
    }
	public boolean validateData() {
		if (str1.length() == 6) {
			return true;
		} else {
			return false;
		}

	}
}
public class Solution
{
	public static void main(String args[])
    {
    	Scanner s = new Scanner(System.in);
    	String input = s.next();
    	InputValidator i = new InputValidator(input);    	
    	System.out.println(i.validateData());

    }

}
