import java.util.Scanner;
import java.util.ArrayList;

/**
 * Quiz class.
 */
class Quiz {
	/**
	 * default quiz constructor.
	 */
	String[] questions;
	int k = 0;
	Quiz() {

	}
	Quiz(final String question1, final int count) {
		questions = new String[count];
	    questions[k++] = question1;
	}

	String[] getQuestion() {
		return this.questions;
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
        // leave this blank
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
         // instantiate this Quiz
        Quiz q = new Quiz();
         // code to read the test cases input file
        Scanner s = new Scanner(System.in);
        // check if there is one more line to process
        while (s.hasNext()) {
            // read the line
            String line = s.nextLine();
             // split the line using space
            String[] tokens = line.split(" ");
              // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "LOAD_QUESTIONS":
                System.out.println("|----------------|");
                System.out.println("| Load Questions |");
                System.out.println("|----------------|");
                loadQuestions(s, q, Integer.parseInt(tokens[1]));
                break;
                case "START_QUIZ":
                System.out.println("|------------|");
                System.out.println("| Start Quiz |");
                System.out.println("|------------|");
                startQuiz(s, q, Integer.parseInt(tokens[1]));
                break;
                case "SCORE_REPORT":
                System.out.println("|--------------|");
                System.out.println("| Score Report |");
                System.out.println("|--------------|");
                displayScore(q);
                break;
                default:
                break;
            }
        }
    }
    /**
     * Loads questions.
     *
     * @param      s              The scanner object for user input
     * @param      quiz           The quiz object
     * @param      questionCount  The question1 count
     */
    public static void loadQuestions(final Scanner s, final Quiz quiz, final int questionCount) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        Quiz question = new Quiz();

        for (int i = 0; i < questionCount; i++) {
        	String line = s.nextLine();
        	String[] question1 = line.split(":");
        	String[] choices = question1[1].split(",");
            if (questionCount < 1) {
        	    System.out.println("Quiz does not have questions");
        	    break;
            } else if (question1.length < 5) {
                System.out.println("Error! Malformed question");
                break;
            } else if (Integer.parseInt(question1[2]) > choices.length) {
            	System.out.println(choices.length);
            	System.out.println("Error! Correct answer choice number is out of range for question text 1");
            	break;
            } else if (choices.length < 1) {
            	System.out.println("trick question  does not have enough answer choices");
            	break;
            } else {
            	System.out.println();
            	new Quiz(line, questionCount);
            }

        }
        System.out.println(questionCount + " " + "are added to the quiz");
    }

    /**
     * Starts a quiz.
     *
     * @param      s            The scanner object for user input
     * @param      quiz         The quiz object
     * @param      answerCount  The answer count
     */
    public static void startQuiz(final Scanner s, final Quiz quiz, final int answerCount) {
        // write your code here to display the quiz questions
        // read the user responses from the console
        // store the user respones in the quiz object
        //String[] questions;
        //questions = quiz.getQuestion();
        //System.out.println(questions[0]);
        // for (int i = 0; i < answerCount; i++) {
        // 	//System.out.println(quiz.getQuestion());
        // 	String line = s.nextLine();
        // 	String[] answer = line.split(" ");
        // }
    }

    /**
     * Displays the score report
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report
    }
}
