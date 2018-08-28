import java.util.Scanner;
/**
@author vamshi
*/
public final class Bigger {
    /**
    @default constructor
    */
    private Bigger() {
    }
    /**
    @param args string
    */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a, b");
        int a = sc.nextInt();
        int b = sc.nextInt();
        if (a > b) {
            System.out.println("a is larger than b");
        } else {
            if (a == b) {
                System.out.println("a is equal to b");
            } else {
                System.out.println("a is smaller to b");
            }
        }

    }
}
