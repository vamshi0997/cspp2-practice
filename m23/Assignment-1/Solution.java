import java.util.regex.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.nio.file.Files;
import java.nio.file.Paths;



class BagOfWords {

}

class StringMatching {

}

class Solution {
    
    public static void main(String[] args) {
        
        String path = "/Users/apple/cspp2-practice/m23/Assignment-1/Test/";
		Scanner scan = new Scanner(System.in);
		String text = scan.nextLine();
			if (text.equals("")) {
				System.out.println("empty directory");
			}
			else {
				File folder = new File("/Users/apple/cspp2-practice/m23/Assignment-1/" + text);
			    fileopen(folder, path);
			}
	}
		
    
    public static void fileopen(File folder, String path) {
    	
    	String currentLine="";
	    File[] listOfFiles = folder.listFiles();
        if (listOfFiles.length == 0) {
        	System.out.println("empty directory");
        }
	}
}