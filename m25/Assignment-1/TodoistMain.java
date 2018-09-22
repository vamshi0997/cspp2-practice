import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

/**
  * write your code below this comment.
  */
class Todoist {
    /**
     * array list.
     */
    private ArrayList<Task> task1 = new ArrayList<Task>();
    /**
     * @deafault constructor.
     */
    Todoist() {
        // taskarray = new Task[10];
        // size = 0;
    }
    /**
     * @param task task.
     */
    public void addTask(final Task task) {
        task1.add(task);
    }
    /**
     * @param name name.
     * @return task.
     */
    public Task getNextTask(final String name) {
        for (Task i: task1) {
            if (i.getName().equals(name)) {
                if (i.getStatus().equals("todo")
                    && i.getImportant().equals("Important")
                    && i.getUrgent().equals("Not Urgent")) {
                    return i;
                }
            }
        }
        return null;
    }
    /**
     * @param name name.
     * @param count count.
     * @return task[]
     */
    public Task[] getNextTask(final String name, final int count) {
        Task[] ntask = new Task[count];
        int j = 0;
        for (Task i: task1) {
            if( i.getName().equals(name)) {
                if (i.getStatus().equals("todo")
                    && i.getImportant().equals("Important")
                    && i.getUrgent().equals("Not Urgent")) {
                    if (j < count) {
                        ntask[j] = i;
                        j++;
                    }
                }
            }
        }
        return ntask;
    }
    /**
     * @return int.
     */
    public int totalTime4Completion() {
        int sum = 0;
        for (Task i: task1) {
            if (i.getStatus().equals("todo")) {
                sum += i.getTime();
            }
        }
        return sum;
    }
    /**
     * @return string.
     */
    public String toString() {
        String s = "";
        for (Task i: task1) {
            System.out.println(i);
        }
        return s;
    }
}

/**
 * task class. 
 */
class Task {
    private String title;
    private String assignedTo;
    private int timeToComplete;
    private boolean important;
    private boolean urgent;
    private String status;
    /**
     * @defaul constructor.
     */
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
    /**
     * @return string.
     */
    public String getImportant() {
        if (this.important == true) {
            return "Important";
        }
        return "Not Important";
    }
    /**
     * @return string.
     */
    public String getName() {
        return this.assignedTo;
    }
    /**
     * @return String.
     */
    public String getStatus() {
        return this.status;
    }
    /**
     * @return String.
     */
    public String getUrgent() {
        if (this.urgent == true) {
            return "Urgent";
        }
        return "Not Urgent";
    }
    /**
     * @return int.
     */
    public int getTime() {
        return this.timeToComplete;
    }
    /**
     * @return string.
     */
    public String toString() {
        return title + ", " + assignedTo + ", "
        + timeToComplete + ", " + getImportant()
        + ", " + getUrgent() + ", " + status;
     }
}

/**
 * Class for todoist main.
 */
public class TodoistMain {
    /**
     * @default.
     */
    private TodoistMain() {

    }

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
                } catch (Exception e) {
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
        final int three = 3;
        final int four = 4;
        final int five = 5;
        final int six = 6;
        String title = tokens[1];
        String assignedTo = tokens[2];
        int timeToComplete = Integer.parseInt(tokens[three]);
        boolean important = tokens[four].equals("y");
        boolean urgent = tokens[five].equals("y");
        String status = tokens[six];
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
