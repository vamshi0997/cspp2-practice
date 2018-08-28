import java.lang.Math.PI;
import java.util.Scanner;
/**
@author vamshi
*/
public final class Area {
    /**
    @default constructor
    */
    private Area() {
    }
    /**
    @param args string
    */
    public static void main(final String[] args) {
        //this is main function
        Scanner sc = new Scanner(System.in);
        System.out.println("enter radius:");
        float radius = sc.nextInt();
        double area = Math.PI * radius * radius;
        System.out.println("area of circle: " + area);
    }
}
