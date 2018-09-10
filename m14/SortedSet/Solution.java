import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;
//import Assignment-1.Set;

/**
 * Class for set.
 * @author : vamshi.
 */
class Set {
    //your code goes here...
    //Good luck :-)
    /**
     * private set.
     */
    private int[] set;
    /**
     * private size.
     */
    private int size;
    /**
     * @default constructor.
     */
    Set() {
    final int num = 10;
    set = new int[num];
    size = 0;
    }
    /**
     * resize method.
     */
    private void resize() {
        set = Arrays.copyOf(set, 2 * set.length);
    }
    /**
     * @return integer.
     */
    public int size() {
        // replace the code below to implement the size method
        return size;
    }
    /**
     * @param item integer.
     */
    public void add(final int item) {
        //Inserts the specified element at the end of the list.
        int flag = 0;
        if (size == set.length) {
            resize();
        }
        if (!contains(item)) {
            if (size == 0) {
                set[size++] = item;  
            }
            else {
                for (int i = 0; i < size; i++) {
                    if (set[i] > item) {
                        size += 1;
                        for(int j = size-1; j > i; j--) {
                        set[j] = set[j-1];
                        }
                        set[i] = item;
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0) {
                    set[size++] = item;
                }
            }
        }
    }
    /**
     * @param item integer.
     */
    public void addAll(final int[] item) {
        if (size == set.length) {
            resize();
        }
        for (int i = 0; i < item.length; i++) {
            add(item[i]);
        }
    }
    /**
     * @return String
     */
    public String toString() {
        // Replace the code below
        if (size == 0) {
            return "{}";
        }
        String str = "{";
        int i = 0;
        for (i = 0; i < size - 1; i++) {
            str = str + set[i] + "," + " ";
        }
        str = str + set[i] + "}";
        return str;
    }
    /**
     * @param item integer.
     * @return boolean.
     */
    public boolean contains(final int item) {
        // Replace the code below
        /*for (int i = 0; i < set.length; i++) {
            if (set[i] == item) {
                return true;
            }
        }
    return false;*/
    return indexOf(item) != -1;
    }
    /**
     * Finds the index of the item in this set.
     * @param  item to be find in this set.
     * @return the index if the item is found in this set,
     * otherwise false.
     */
    public int indexOf(final int item) {
        for (int i = 0; i < size; i++) {
            if (set[i] == item) {
                return i;
            }
        }
        return -1;
    }
    /**
     * @param start integer.
     * @param end integer.
     *
     * @return int[]
     */
    public int[] subSet(final int start, final int end) {
        int k = 0;
        int[] newset = new int[10];
        if (start > end) {
            System.out.println("Invalid​ Arguments​ to​ Subset​ Exception");
            return null;
        }
        else {
            for (int i = 0; i < size; i++) {
                if(set[i] == start) {
                    //System.out.println(set[i]);
                    for (int j = i; j < indexOf(end) ; j++) {
                        newset[k] = set[j];
                        k ++;
                    }
                }
            }
        }
        return Arrays.copyOf(newset,k);
    }
    public int[] headSet(final int element) {
        int i = 0;
        int[] newset = new int[10];
        if(element < set[0]) {
            return new int[]{};
        } else if (element > set[size-1]) {
            return set;
        } else {
            for (i = 0; i < size; i ++) {
                if (element <= set[i]) {
                    break;
                }
                newset[i] = set[i];
            }
        }
        return Arrays.copyOf(newset, i);
    }
/**
 * @return int.
 */
    public int last() {
        if (size == 0) {
            System.out.println("Set​ Empty​ Exception");
            return 0;
        }
        return set[size-1];
    }
    
}


/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * helper function to convert string input to int array.
     *
     * @param      s     { string input from test case file }
     *
     * @return     { int array from the given string }
     */
    public static int[] intArray(final String s) {
        String input = s;
        if (input.equals("[]")) {
            return new int[0];
        }
        if (s.contains("[")) {
            input = s.substring(1, s.length() - 1);
        }
        return Arrays.stream(input.split(","))
                            .mapToInt(Integer::parseInt)
                            .toArray();
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this set
        Set s = new Set();
        // code to read the test cases input file
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "size":
                System.out.println(s.size());
                break;
                case "contains":
                System.out.println(s.contains(Integer.parseInt(tokens[1])));
                break;
                case "print":
                System.out.println(s);
                break;
                case "add":
                s.add(Integer.parseInt(tokens[1]));
                break;
                case "addAll":
                int[] intArray = intArray(tokens[1]);
                s.addAll(intArray);
                break;
                case "subSet":
                intArray = intArray(tokens[1]);
                int[] t = s.subSet(intArray[0],intArray[1]);
                if (t != null) {    
                System.out.println(Arrays.toString(t).replace("[","{").replace("]","}"));
                }
                break;
                case "headSet":
                intArray = intArray(tokens[1]);
                System.out.println(Arrays.toString(s.headSet(intArray[0])).replace("[","{").replace("]","}"));
                break;
                case "last":
                int temp = s.last();
                if (temp != 0) {
                    System.out.println(temp);
                }
                break;
                default:
                break;
            }
        }
    }
}
