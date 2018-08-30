import java.util.Scanner;
public class Solution {
	/* Fill the main function to print resultant of addition of matrices*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int rows1 = sc.nextInt();
		int columns1 = sc.nextInt();
		int[][] matrix1 = new int[rows1][columns1];
		for (int i = 0; i < rows1; i++){
	    	for (int j = 0; j < columns1; j++){
	    		matrix1[i][j] = sc.nextInt();
	    	}
	    }

	    int rows2 = sc.nextInt();
		int columns2 = sc.nextInt();
		int[][] matrix2 = new int[rows2][columns2];
	    for (int i = 0; i < rows2; i++){
	    	for (int j = 0; j < columns2; j++){
	    		matrix2[i][j] = sc.nextInt();
	    	}
	    }

	    int[][] arr = new int[rows1][columns1];
	    if (rows1 == rows2 && columns1 == columns2){
            for(int i = 0; i < rows1; i ++){
                for (int j = 0; j < columns1; j++){
                    arr[i][j] = matrix1[i][j] + matrix2[i][j];
                }
            System.out.println(arr[i][0] + " " + arr[i][1] + " " + arr[i][2]);
            }
	    } else {
	        	System.out.println("not possible");
	      }
	}
}
