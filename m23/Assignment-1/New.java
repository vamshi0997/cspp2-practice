
import java.io.File;
import java.util.Scanner;

public class New {
    public static void main(String[] args) throws Exception {
        File file = new File("/Users/apple/cspp2-practice/m23/Test/Assignment-1/");
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine()){
            System.out.println(sc.nextLine());
        }
    }
}