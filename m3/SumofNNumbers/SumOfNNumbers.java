import java.util.Scanner;
/**
 * @author vamshi
 */
public final class SumOfNNumbers {
    /**
     * @brief creating a default constructor.
     * @details default constructor
     */
    private SumOfNNumbers() {

    }
    /**
     * @brief entering into main method.
     * @details main method
     * @param args string
     */
    public static void main(final String[] args) {
        int i = 1, sum = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Number: ");
        int n = sc.nextInt();
        while (i <= n) {
            sum = sum + i;
            i = i + 1;
        }
        System.out.println(sum);
    }
}
