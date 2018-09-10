package Assignment-1;
import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

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
        if (size == set.length) {
            resize();
        }
        int flag = 1;
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                if (set[i] == item) {
                    flag = 0;
                }
            }
            if (flag == 1) {
                    set[size++] = item;
            }
        } else {
            set[size++] = item;
        }
    }
    /**
     * @param item integer.
     */
    public void add(final int[] item) {
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
        for (int i = 0; i < set.length; i++) {
            if (set[i] == item) {
                return true;
            }
        }
    return false;
    }
    /**
     * @brief [brief description]
     * @details [long description]
     *
     * @param comparearray set.
     * @return Set.
     */
    public Set intersection(final Set comparearray) {
        Set newset = new Set();
        for (int i = 0; i < size(); i++) {
            for (int j = 0; j < comparearray.size; j++) {
                if (comparearray.set[j] == set[i]) {
                    newset.add(set[i]);
                }
            }
        }
        return newset;
    }

    /**
     * @param comparearray int[]
     * @return Set.
     */
    public Set retainAll(final int[] comparearray) {
        Set newset = new Set();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < comparearray.length; j++) {
                if (comparearray[j] == set[i]) {
                    newset.add(set[i]);
                }
            }
        }
        return newset;
    }
    /**
     * @param compareset Set
     * @return int[][]
     */
    public int[][] cartesianProduct(final Set compareset) {
        int num = 0;
        int[][] newarray = new int[size * compareset.size()][2];
        if (size == 0 || compareset.size() == 0) {
            return null;
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < compareset.size(); j++) {
                    //System.out.println(set[]);
                if (num < size * compareset.size()) {
                    newarray[num][0] = set[i];
                    newarray[num][1] = compareset.set[j];
                    num++;
                }
            }
        }
        return newarray;
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
                int[] intArray = intArray(tokens[1]);
                if (intArray.length == 1) {
                    s.add(intArray[0]);
                } else {
                    s.add(intArray);
                }
                break;
                case "intersection":
                s = new Set();
                Set t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(s.intersection(t));
                break;
                case "retainAll":
                s = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
                case "cartesianProduct":
                s = new Set();
                t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
                break;
                default:
                break;
            }
        }
    }
}