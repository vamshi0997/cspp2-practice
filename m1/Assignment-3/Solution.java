import java.util.Scanner;

public class Solution {
    /*
    Do not modify this main function.
    */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double degreesCelsius = scan.nextDouble();
		calculateFromDegreesToFarenheit(degreesCelsius);
	}
	/*
	Need to fill the calculateFromDegreesToFarenheit function and
	print the output of fahrenheit.
	*/
	static void calculateFromDegreesToFarenheit(double degreesCelsius) {
		/*
		write the formula for conversion
		*/
		double faren = (9 * degreesCelsius) / 5 + 32;
		System.out.println(faren);
	}
}
