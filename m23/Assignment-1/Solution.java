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


class Bag {
	
	String[] textdoc1;
	String[] textdoc2;
	String[] both;
	
	Bag(String[] text1, String[] text2) {
		this.textdoc1 = text1;
		this.textdoc2 = text2;
		this.both = new String[text1.length + text2.length];
		
		int size = 0;
		for (String i : text1) {
			both[size++] = i;
			
		}
		
		for (String i : text2) {
			both[size++] = i;
			
		}
		
	}
	
	int count(String[] doc, String word) {
		int count = 0;
		for (String i : doc) {
			if (i.equalsIgnoreCase(word)) {
				count++;
			}
		}
		return count;
	}
	
	
	
	
	HashMap<String, Integer> computedoc(String[] text1, String[] text2) {
		HashMap<String, Integer> map = new HashMap<String, Integer>(); 
		for (String i : text2) {
			int count1 = this.count(text1, i);
			if(!map.containsKey(i.toLowerCase())) {
				map.put(i.toLowerCase(), count1);
			}
		}
		return map;
	}
	
	double euclidean(HashMap<String, Integer> map) {
		
		double denom = 0;
		
		for (int i : map.values()) {
			denom += Math.pow(i, 2);
		}
		
		return Math.sqrt(denom);
	}
	
	
	
	double dot(HashMap<String, Integer> seq1, HashMap<String, Integer> seq2) {
		double num = 0;
		for (String key : seq1.keySet()) {
			num += seq1.get(key) * seq2.get(key);
		}
		
		return num;
	}
	
	
	double Frequency() {
		HashMap<String, Integer> s1 = computedoc(this.textdoc1, this.both);
		HashMap<String, Integer> s2 = computedoc(this.textdoc2, this.both);
		
		return 	dot(s1,s2) / (euclidean(s1) * euclidean(s2));
	}
}
	

	

class Matching {
    String[] doc1;
	String[] doc2;
	
	
	Matching(String[] textdoc1, String[] textdoc2) {
		this.doc1 = textdoc1;
		this.doc2 = textdoc2;
	}
	
	double compute() {
		
		double lcs = 0;
        int count = 0;
		for (String i : this.doc1) {
			Pattern p = Pattern.compile(i,Pattern.CASE_INSENSITIVE);
			Matcher m = p.matcher(Arrays.toString(this.doc2).replace("[","").replace("]","").replace(",",""));
			
			while (m.find()) {
                count++;
				if (lcs < i.length()){
                    lcs = i.length();
                }
			}
			
		}

		double length = Arrays.toString(this.doc1).replace("[","").replace("]","").replace(",","").length() +
						Arrays.toString(this.doc2).replace("[","").replace("]","").replace(",","").length();
		
		return lcs * count * 100 / length;
	}
}

class Solution {
    
    public static void main(String[] args) {
        
        String path = "/Users/apple/cspp2-practice/m23/Assignment-1/Test/";
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			String str = scan.nextLine();
			File folder = new File("/Users/apple/cspp2-practice/m23/Assignment-1/" + str);
			fileopen(folder, path);
		}
	}	
    
    public static void fileopen(File folder, String path) {
	    File[] listOfFiles = folder.listFiles();
	    if (listOfFiles.length == 0) {
           System.out.println("empty directory");
           return;
	     }
	    String[] text = new String[listOfFiles.length];
	    int i = 0;
	    try {
	        for (File f: listOfFiles) {
	        	String p = path + f.getName();
                text[i++] = new String(Files.readAllBytes(Paths.get(p)));
	        }
	    } catch (Exception e) {

	    }
	    for (String j: text) {
	    	String[] str1 = j.split(" ");
	    	for (String k: text) {
	    		String[] str2 = k.split(" ");
	    		Bag b = new Bag(str1, str2);
	    		double result = b.Frequency();
	    		System.out.print(Math.round(result * 100));
	    		System.out.print(" " + "\t");
	    	}
	    	System.out.println();
	    }
	    return;
	}
}