import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;
//import java.util.ArrayList;

/**
 * @author vamshi
 */
public final class List {
    //Implement all the methods mentioned to build a ListADT

    /*
     * The goal for the list is to store items.
     * How are we going to store the items in the list?
     * An array would be good. Right?
     * So, assume we are only going to have ints in the list
     * We need to create an array of ints to store the items
     * added to the list.
     *
     * Create a variable of the type int[]
     * Use the private access specifier
     * Why private access specifier and why not public?
     * Well, we don't want the array to be manipulated by
     * methods that are outside the List class.
     * If you allow methods outside the List class to manipulate
     * the array then there is a possibility of having a corrupted
     * list i.e., a list with incorrect items.
     * This is not desirable and so having private access specifer
     * will protect the array such corruption.
     * This is a hard concept to understand. Discuss with your mentor.
     *
    */
    // declare a private int[]
    // don't create the array yet using new
    // that's the job of the List constructor
    /**
     * @class attribute.
     */
    private String[] array;

    /*
     * What are the other class variables needed for creating a list?
     * How about keeping track of the size of the list?
     * If you add 2 items to the list then the size should be 2.
     * Let's think about the size of the list by comparing it to the
     * length of the array. Do they mean the same?
     * No, Array length signifies the maximum number of items
     * you can store in the list. Whereas, the size of the list
     * denotes the number of items in the list. Makes sense?
     * Here is an example:
     * array = [1,2,3,0,0,0,0,0,0,0]
     * The length of the array is 10 and size is 3.
     * This means you can store 10 items in the list and
     * currently it has 3 items.
     * So, to keep track of the size we need a variable called size
     * Again, we use private as we don't want that size variable
     * to be accessed by the methods that are outside of the List class.
     */

    // declare a private int size
    // again, don't initialize it here
    // variable initialization should be done in the constructor
    /**
     * @ class attribute.
     */
    private int size;

    /*
     * The purpose of the constructor is to initialize the
     * class variables with some default values.
     */
     /**
      * @default constructor.
      */
    public List() {

        // what are the two variables to be initialized here?
        // think about the private variables described above.
        // What should be the default values?
        // In the case of the list, it should be empty but
        // it should be initialized with an array size like 10

        // Think about the initial value for size.
        // How many items do we have in the list when you create it?
        // An empty list has how many items?
        // That is the initial value to use for size.
        final int num = 10;
        array = new String[num];
        size = 0;
    }

    /*
     * The add method does what the name suggests.
     * Add an int item to the list.
     * The assumption is to store the item at the end of the list
     * What is the end of the list?
     * Is it the same as the end of the array?
     * Think about how you can use the size variable to add item
     * to the list.
     * The method returns void (nothing)
     */
    /**
     * @param item integer.
     */
    public void add(final String item) {
        //Inserts the specified element at the end of the list.
        if (size == array.length) {
            resize();
        }
        for (int i = size; i <= size; i++) {
            array[size] = item;
        }
        size += 1;
    }
    /**
     * resize method.
     */
    private void resize() {
        array = Arrays.copyOf(array, 2 * array.length);
    }

    /*
     * The size method returns the value of the size.
     * The purpose of the method is to announce the size of the list
     * to the objects outside the list
     * The method returns an int. Empty list should return 0.
     */
    /**
     * @return integer.
     */
    public int size() {
        // replace the code below to implement the size method
        return size;
    }

    /*
     * The remove method does what the name suggests.
     * Removes an int item, specified by the index argument, from the list
     * It also does an additional step.
     * Think about what happens when
     * an item is removed from the middle of the list
     * It creates a hole in the list, right?
     * This would mean, all the items that are
     * to the right side of the removed item should be
     * moved to the left by one position.
     * Here is an example:
     * array = [1,2,3,0,0,0,0,0,0,0]
     * remove(2) would remove the item 2
     * But how do you remove the item from an array?
     * Well, the way to remove it is to move all
     * the items, that are to the right of the removed item, to the left
     * So, the new array looks like this.
     * array = [1,3,0,0,0,0,0,0,0,0]
     * The method returns void (nothing)
     */
    /**
     * @param index int
     */
   public void remove(final int index) {
        // write the logic for remove here.
        // Think about what to do to the size variable.
        if (index < size && index >= 0) {
            for (int i = 0; i <= size; i++) {
                if (i == index) {
                    for (int j = i; j < array.length - 1; j++) {
                        array[j] = array[j + 1];
                    }
                    break;
                }
            }
        size = size - 1;
        } else {
            System.out.println("Invalid Position Exception");
        }
    }

    /**
     * @param items int[]
     */
    public void addAll(final String[] items) {
        if (size + items.length >= array.length) {
            resize();
        }
        for (int i = 0; i < items.length; i++) {
            array[size] = items[i];
            size += 1;
        }
    }

    /**
     * @param index integer
     * @param item integer
     */
    public void add(final int index, final String item) {
        if (size == array.length) {
            resize();
        }
        if (size != 0 && index < size && index > 0) {
            size += 1;
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
            if (i == index) {
                array[index] = item;
            }
        }
        } else if (index == 0) {
            array[index] = item;
            size += 1;
        } else if (index < 0) {
            System.out.println("Negative Index Exception");
        }
    }
    /**
     * @param item integer.
     * @return integer.
     */
    public int count(final String item) {
        int count1 = 0;
        for (int i = 0; i < size; i++) {
            if (array[i] == item) {
                count1 += 1;
            }
        }
        return count1;
    }

    /*
     * Get method has to return the items that is
     * at the index position passed as an argument to the method.
     * If the item doesn't exist then return a -1 to indicate that
     * there is no element at that index.
     * How can an element not be there at a given position?
     * Well, if the position is greater than the number of items
     * in the list then that would mean the item doesn't exist.
     * How do we check if the position is greater than the
     * number of items in the list? Would size variable be useful?
     */
    /**
     * @param index integer
     * @return integer
     */
    public int get(final int index) {
        // Replace the code below to write the code for get
        if (index < size && index >= 0) {
        for (int i = 0; i < size; i++) {
            if (i == index) {
                return array[i];
            }
        }
        }
    return -1;
    }

    /**
     * What happens when you print an object using println?
     * Java provides a method named toString that is internally
     * invoked when an object variable is used in println.
     * For example:
     * List l = new List();
     * System.out.println(l);
     * This statement is a shortcut for
     * System.out.println(l.toString());
     * So, implement the toString method to display the items
     * in the list in the square brackets notation.
     * i.e., if the list has numbers 1, 2, 3
     * return the string [1,2,3]
     * Caution: The array may be having other elements
     * Example: [1,2,3,0,0,0,0,0,0,0]
     * toString should only return the items in the list and
     * not all the elements of the array.
     * @return string
     */
    public String toString() {
        // Replace the code below
        String[] arr = new String[size];
        for (int i = 0; i < size; i++) {
            arr[i] = array[i];
        }
        return Arrays.toString(arr).replace(" ", "");
    }

    /**
     * Contains return true if the list has.
     * the item passed as an argument to the method
     * So, iterate through the list and return true if
     * the item exists and otherwise false
     * @param item integer
     * @return boolean
     */
    public boolean contains(final String item) {
        // Replace the code below
        for (int i = 0; i < array.length; i++) {
            if (array[i] == item) {
                return true;
            }
        }
    return false;
    }

    /**
     * Returns the index of the first occurrence
     * of the specified element in this list,
     * or -1 if this list does not contain the element.
     * @param item final
     * @return int
     */
    public int indexOf(final int item) {
        // Replace the code below
        for (int i = 0; i < array.length; i++) {
            if (array[i] == item) {
                return i;
            }
        }
    return -1;
    }

    /**
     * main class.
     * @param args string
     */
    public static void main(final String[] args) {
        // create an object of the list to invoke methods on it
        List l = new List();

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
                case "add":
                try {
                l.add(tokens[1]);
                } catch (Exception e) {
                String[] tokens1 = tokens[1].split(",");
                l.add(Integer.parseInt(tokens1[0]),
                    Integer.parseInt(tokens1[1]));
                }
                break;
                case "size":
                // invoke size method and print the list size
                // BTW, list size is not the array size
                // it is the number of items in the list
                System.out.println(l.size());
                break;
                case "print":
                // print the list (implement toString for this to work)
                // expected format is [item-1,item-2,...,item-n]
                // review the output testcase file
                System.out.println(l);
                break;
                case "remove":
                l.remove(tokens[1]);
                break;
                case "indexOf":
                System.out.println(l.indexOf(tokens[1]));
                break;
                case "get":
                int temp = l.get(tokens[1]);
                if (temp != -1) {
                System.out.println(temp);
                } else {
                System.out.println(-1);
                }
                break;
                case "contains":
                System.out.println(l.contains(tokens[1]));
                break;
                case "count":
                System.out.println(l.count(tokens[1]));
                break;
                case "addAll":
                if (tokens.length > 1) {
                String[] tokens1 = tokens[1].split(",");
                int[] arr = new int[tokens1.length];
                for (int i = 0; i < tokens1.length; i++) {
                    arr[i] = tokens1[i];
                }
                l.addAll(arr);
                }
                break;
                default:
                break;
            }
        }
    }
}
