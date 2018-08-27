import java.util.Scanner;

public class Solution {
	/*
	Do not modify this main function.
	*/
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int base = scan.nextInt();
		int height = scan.nextInt();
		float area = areaOfTriangle(base, height);
		System.out.println(area);
	}
	/*
	Need to fill the areaOfTriangle function and print the output
	of fahrenheit.
	*/
	static float areaOfTriangle(int base, int height){
        float area = (base * height)/2;
        return area;
	}
}