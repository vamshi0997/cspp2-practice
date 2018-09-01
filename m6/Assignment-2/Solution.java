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
        int d1 = 0, d2 = 0;
        final int hun5 = 500,hun4 = 400, hun3 = 300, hun2 = 200, hun1 = 100;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (a[i][j] > hun4) {
                    d1 = hun5 - a[i][j];
                    d2 = a[i][j] - hun4;
                    if (d1 >= d2){
                        a[i][j] = hun4;
                    } else {
                        a[i][j] = hun5;
                    }
                } else if (a[i][j] > hun3) {
                    d1 = hun4 - a[i][j];
                    d2 = a[i][j] - hun3;
                    if (d1 >= d2){
                        a[i][j] = hun3;
                    } else {
                        a[i][j] = hun4;
                    }
                } else if (a[i][j] > hun2) {
                    d1 = hun3 - a[i][j];
                    d2 = a[i][j] - hun2;
                    if (d1 >= d2){
                        a[i][j] = hun2;
                    } else {
                        a[i][j] = hun3;
                    }
                } else if (a[i][j] > hun1) {
                    d1 = hun2 - a[i][j];
                    d2 = a[i][j] - hun1;
                    if (d1 >= d2){
                        a[i][j] = hun1;
                    } else {
                        a[i][j] = hun2;
                    }
                } else {
                    d1 = hun1 - a[i][j];
                    d2 = a[i][j];
                    if (d1 >= d2){
                        a[i][j] = 0;
                    } else {
                        a[i][j] = hun1;
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
