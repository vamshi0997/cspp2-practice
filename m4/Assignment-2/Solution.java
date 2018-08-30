import java.util.Scanner;
/**
 * @author vamshi
 */
public final class Solution {
    /**
     * Fill the main function to print resultant of addition of matrices.
     * @default constructor
     */
    private Solution() {

    }
    /**
     * @param args string
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows1 = sc.nextInt();
        int columns1 = sc.nextInt();
        int[][] matrix1 = matrix_(rows1, columns1);

        int rows2 = sc.nextInt();
        int columns2 = sc.nextInt();
        int[][] matrix2 = matrix_(rows2, columns2);
        

        int[][] arr = new int[rows1][columns1];
        if (rows1 == rows2 && columns1 == columns2) {
            for (int i = 0; i < rows1; i++) {
                for (int j = 0; j < columns1; j++) {
                    arr[i][j] = matrix1[i][j] + matrix2[i][j];
                }
            System.out.println(arr[i][0] + " " + arr[i][1] + " " + arr[i][2]);
            }
        } else {
                System.out.println("not possible");
          }
    }
    static int[][] matrix_(int rows, int columns){
        Scanner s = new Scanner(System.in);
        int[][] matrix1 = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix1[i][j] = s.nextInt();
            }
        }
        return matrix1;
    }
}
