//import java.util.Array;
import java.util.Scanner;
public final class FirstLast6{
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter length of string:");
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++){
		    arr[i] = sc.nextInt();	
		}
		if(arr[0] == 6 || arr[arr.length-1] == 6){
            System.out.println("true");
		} else {
			System.out.println("false");
		  }
	}
}