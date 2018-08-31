import java.util.Scanner;
/**
 * @author vamshi
 */
public final class Concatinate {
    /**
     * @default constructor
     */
    private Concatinate() {

    }
    /**
     * @param args string
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the number: ");
        int num = Integer.parseInt(sc.nextLine());
        System.out.println("enter arguments one after another: ");
        for (int i = 0; i <= num-1; i++){
            String str = sc.nextLine();
            String str1 = "";
            str1 = str1.concat("Hello ") + str1.concat(str) + str1.concat("!");
            System.out.println(str1);
    }
    }
    
}
