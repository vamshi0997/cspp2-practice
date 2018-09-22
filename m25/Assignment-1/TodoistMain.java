import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

/**
  * write your code below this comment
  */
class Todoist {
    ArrayList<Task> task1 = new ArrayList<Task>(); 
    Task[] taskarray;
    int size;
    Todoist() {
        // taskarray = new Task[10];
        // size = 0;
    }
    // private void resize() {
    //     taskarray = Arrays.copyOf(taskarray, 2 * taskarray.length);
    // }
    // public int size() {
    //     return size;
    // }
    public void addTask(Task task) {
        // if(size == taskarray.length) {
        //     resize();
        // }
        // taskarray[size++] = task;
        task1.add(task);
        // for(Task i: task1) {
        //     System.out.println(i);
        // }
    }
    public Task getNextTask(String name) {
        for (Task i: task1) {
            if(i.getName().equals(name)) {
                if (i.getStatus().equals("todo") && i.getImportant().equals("Important") && i.getUrgent().equals("Not Urgent")) {
                    return i;
                }
            }
        }
        return null;
    }
    public Task[] getNextTask(String name, int count) {
        Task[] ntask = new Task[count];
        int j = 0;
        for (Task i: task1) {
            if(i.getName().equals(name)) {
                if (i.getStatus().equals("todo") && i.getImportant().equals("Important") && i.getUrgent().equals("Not Urgent")) {
                    if(j < count) {
                        ntask[j] = i;
                        j++;
                    }
                }
            }
        }
        return null;
    }
    public int totalTime4Completion() {
        int sum = 0;
        for (Task i: task1) {
            if (i.getStatus().equals("todo")) {
                sum += i.getTime();
            }
        }
        return sum;
    }
    public String toString() {
        String s = "";
        for(Task i: task1) {
            System.out.println(i);
        }
        return s;
    }
}
class Task {
    String title;
    String assignedTo;
    int timeToComplete;
    boolean important;
    boolean urgent;
    String status;
    Task(String title1, String assignedTo1, int timeToComplete1, boolean important1, boolean urgent1, String status1) throws Exception {
        if (title1.equals("")) {
            throw new Exception("Title not provided");
        } else {
            this.title = title1;
        }
        if (timeToComplete1 < 0) {
            throw new Exception("Invalid timeToComplete -1");
        } else {
            this.timeToComplete = timeToComplete1;
        }
        if (status1.equals("todo") || status1.equals("done")) {
            this.status = status1;
        } else {
            throw new Exception("Invalid status dud");
        }
        this.assignedTo = assignedTo1;
        this.important = important1;
        this.urgent = urgent1;
    }

    String getImportant() {
        if (this.important == true) {
            return "Important";
        }
        return "Not Important";
    }
    String getName() {
        return this.assignedTo;
    }
    String getStatus() {
        return this.status;
    }

    String getUrgent() {
        if (this.urgent == true) {
            return "Urgent";
        } else {
            return "Not Urgent";
        }
    }
    public int getTime() {
        return this.timeToComplete;
    }
    public String toString() {
        return title + ", " + assignedTo + ", " + timeToComplete + ", " + getImportant() + ", " + getUrgent() + ", " + status;
     }
}

/**
 * Class for todoist main.
 */
public class TodoistMain {

    /**
     * Starts a test.
     */
    public static void startTest() {
        Todoist todo = new Todoist();
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String[] tokens = s.nextLine().split(",");
            switch (tokens[0]) {
                case "task":
                try {
                    testTask(tokens);
                } catch(Exception e) {
                    System.out.println(e);
                }
                break;
                case "add-task":
                     testAddTask(todo, tokens);
                break;
                case "print-todoist":
                    System.out.println(todo);
                break;
                case "get-next":
                    System.out.println(todo.getNextTask(tokens[1]));
                break;
                case "get-next-n":
                    int n = Integer.parseInt(tokens[2]);
                    Task[] tasks = todo.getNextTask(tokens[1], n);
                    System.out.println(Arrays.deepToString(tasks));
                break;
                case "total-time":
                    System.out.println(todo.totalTime4Completion());
                break;
                default:
                break;
            }
        }
    }

    /**
     * method to test add task.
     *
     * @param      todo    The todo
     * @param      tokens  The tokens
     */
    public static void testAddTask(final Todoist todo, final String[] tokens) {
        try {
            todo.addTask(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * method to test the creation of task object.
     *
     * @param      tokens  The tokens
     */
    public static void testTask(final String[] tokens) {
        try {
            System.out.println(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Creates a task object.
     *
     * @param      tokens     The tokens
     *
     * @return     Task object
     *
     * @throws     Exception  if task inputs are invalid
     */
    public static Task createTask(final String[] tokens) throws Exception {
        String title = tokens[1];
        String assignedTo = tokens[2];
        int timeToComplete = Integer.parseInt(tokens[3]);
        boolean important = tokens[4].equals("y");
        boolean urgent = tokens[5].equals("y");
        String status = tokens[6];
        return new Task(
            title, assignedTo, timeToComplete, important, urgent, status);
    }

    /**
     * main method.
     *
     * @param      args  The command line arguments
     */
    public static void main(final String[] args) {
        startTest();
    }
}
