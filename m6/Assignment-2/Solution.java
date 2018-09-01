import java.util.Scanner;
/**
 * Write a java program to round the
 * elements of a matrix to the nearest 100.
 *
 * @author : 
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //not used
    }
    /**
     * Function to round the
     * elements of a matrix to the nearest 100.
     *
     * @param      a     Matrix of which the elements to be rounded
     * @param      rows     Number of rows
     * @param      columns     Number of columns
     *
     * @return     Matrix of the rounded elements
     */
    static int[][] roundHundred(final int[][] a, final int rows, final int columns) {

	// write ypur code here
        int d1 = 0, d2 =0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (a[i][j] > 400) {
                    d1 = 500 - a[i][j];
                    d2 = a[i][j] - 400;
                    if (d1 >= d2){
                        a[i][j] = 500;
                    } else {
                        a[i][j] = 400;
                    }
                }
                else if (a[i][j] > 300) {
                    d1 = 400 - a[i][j];
                    d2 = a[i][j] - 300;
                    if (d1 >= d2){
                        a[i][j] = 400;
                    } else {
                        a[i][j] = 300;
                    }
                }
                else if (a[i][j] > 200) {
                    d1 = 300 - a[i][j];
                    d2 = a[i][j] - 200;
                    if (d1 >= d2){
                        a[i][j] = 300;
                    } else {
                        a[i][j] = 200;
                    }
                }
                else if (a[i][j] > 100) {
                    d1 = 200 - a[i][j];
                    d2 = a[i][j] - 100;
                    if (d1 >= d2){
                        a[i][j] = 200;
                    } else {
                        a[i][j] = 100;
                    }
                }
                else {
                    d1 = 100 - a[i][j];
                    d2 = a[i][j];
                    if (d1 >= d2){
                        a[i][j] = 100;
                    } else {
                        a[i][j] = 0;
                    }
                }
	        }
        }
        return a;
    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scan.nextInt();
            }
        }
        int[][] b = roundHundred(a, m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 1; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println(b[i][n - 1]);
        }
    }
}
