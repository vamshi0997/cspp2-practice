
import java.util.*;
public class Solution {
    /*
	Fill this main function to print maximum of given array
	*/
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++){
		    arr[i] = sc.nextInt();	
		}
		int max = 0;
	    for (int j = 0; j < arr.length; j++){
	    	if (arr[j] > max){
	    		max = arr[j];
	    	}
	    }
	    System.out.println(max);
	}
}
