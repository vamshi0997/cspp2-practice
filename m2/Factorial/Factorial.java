import java.util.Scanner;
/**
@author vamshi
*/
public final class Factorial {
    /**
    @default constructor
    */
    private Factorial() {
    }
    /**
    @param args string
    */
    public static void main(final String[] args) {
        System.out.print("enter a number: ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        System.out.format("fact of %d is %d.%n", number, fact(number));
    }
    /**
    @param n integer
    @return n * fact(n - 1) integer
    */
    static int fact(final int n) {
        if ((n == 1) || (n == 0)) {
            return 1;
        } else {
            return n * fact(n - 1);
        }
    }
}
