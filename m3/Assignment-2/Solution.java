import java.util.Scanner;
/*
	Do not modify this main function.
	*/
public class Solution {
/* Fill the main function to print the number of 7's between 1 to n*/
    public static void main(String[] args) {

        Scanner s=new Scanner(System.in);      
        int n = s.nextInt();
        int r = 0;
        for (int i = 1; i < n; i++){
        	r += count(i);
        	}
        System.out.println(r);
    }
    public static int count(int i){
    	int count1 = 0;
    	while (i > 0){
        	if (i % 10 == 7){
        		count1 += 1;
        	}
        	i = i / 10;
        }
        return count1;
    }
}
