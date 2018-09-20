import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;





class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String text = scan.nextLine();
		if (text == null) {
			System.out.println("empty directory");
		} else if (text == "Test") {
			File folder = new File("/Users/apple/cspp2-practice/m23/Assignment-1/Test");
			fileopen(folder);

		} else if (text == "Test2") {
			File folder = new File("/Users/apple/cspp2-practice/m23/Assignment-1/Test2");
            fileopen(folder);
		} else {
			File folder = new File("/Users/apple/cspp2-practice/m23/Assignment-1/Test3");
            fileopen(folder);
		}
	}

		static void fileopen(File folder) {
			File[] listOfFiles = folder.listFiles();
            for (File file : listOfFiles) {
			    if (file.isFile()) {
				    System.out.println(file.getName());
			    }
		    }
		}
}