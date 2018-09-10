//import Assignment.Set;
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedInputStream;
/**
 * @author vamshi
 */
class SortedSet extends Set {

    /**
     * @default constructor
     */
    SortedSet() {
        super();
    }

    /**
     * @param item integer.
     */
    @Override
    public void add(final int item) {
        //Inserts the specified element at the end of the list.
        int flag = 0;
        if (size == set.length) {
            resize();
        }
        if (!contains(item)) {
            if (size == 0) {
                set[size++] = item;
            } else {
                for (int i = 0; i < size; i++) {
                    if (set[i] > item) {
                        size += 1;
                        for (int j = size - 1; j > i; j--) {
                        set[j] = set[j - 1];
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
     * @param item int[]
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
     * @param start int
     * @param end int
     * @return int[]
     */
    public int[] subSet(final int start, final int end) {
        int k = 0;
        int[] newset = new int[TEN];
        if (start > end) {
            System.out.println("Invalid Arguments to Subset Exception");
            return null;
        } else {
            for (int i = 0; i < size; i++) {
                if (set[i] >= start && end > last()) {
                for (int j = i; j <= indexOf(last()); j++) {
                        newset[k] = set[j];
                        k++;
                    }
                break;
                } else if (set[i] >= start) {
                    for (int j = i; j < indexOf(end); j++) {
                        newset[k] = set[j];
                        k++;
                    }
                break;
                }
            }
        }
        return Arrays.copyOf(newset, k);
    }
    /**
     * @param element integer.
     * @return int[]
     */
    public int[] headSet(final int element) {
        int i = 0;
        int[] newset = new int[TEN];
        if (element < set[0]) {
            return new int[]{};
        } else {
            for (i = 0; i < size; i++) {
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
            System.out.println("Set Empty Exception");
            return -1;
        }
        return set[size - 1];
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
        SortedSet s = new SortedSet();
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
            case "print":
                System.out.println(s);
                break;
            case "add":
                int[] intArray = intArray(tokens[1]);
                s.add(intArray[0]);
                break;
            case "addAll":
                intArray = intArray(tokens[1]);
                s.addAll(intArray);
                break;
            case "subSet":
                intArray = intArray(tokens[1]);
                int[] t = s.subSet(intArray[0], intArray[1]);
                if (t != null) {
                System.out.println(Arrays.toString(t).replace(
                    "[", "{").replace("]", "}"));
                }
                break;
            case "headSet":
                intArray = intArray(tokens[1]);
                System.out.println(Arrays.toString(
                    s.headSet(intArray[0])).replace(
                    "[", "{").replace("]", "}"));   
                break;
            case "last":
                System.out.println(s.last());
            default:
                break;
            }
        }
    }
}
