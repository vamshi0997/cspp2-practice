//import java.util.Array;
import java.util.Scanner;
public final class Average{
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("enter length of string: ");
		int n = sc.nextInt();
		int sum = 0;
		int[] arr = new int[n];
		for (int i = 0; i < n; i++){
		    arr[i] = sc.nextInt();
		    sum = sum + arr[i];	
		}
		float avg = sum / arr.length;
		System.out.println("Avg of numbers in array: " + avg);
	}
}