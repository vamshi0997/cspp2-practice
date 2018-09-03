import java.util.Scanner;
/**
 * @author vamshi
 */
class Student{
	String Name;
	String Rollnumber;
	double[] Marks = new double[3];
	double sum = 0;
	/**
	 * @param name string
	 * @param Rollno string
	 * @param marks double
	 */
	Student(String name, String Rollno, double[] marks) {
		Name = name;
		Rollnumber = Rollno;
		Marks = marks;
	}
	/**
	 * @return float
	 */
	public float GPA(){
		final int three = 3;
		for (int i = 0; i < Marks.length; i++) {
            sum = sum + Marks[i];
		}
		return (float)sum/three;
	}
}


/**
 * main class.
 */
public final class StudentDetails {
	/**
	 * @default constructor
	 */
	private StudentDetails() {

	}
	/**
	 * @param String args
	 */
	public static void main(String[] args) {
        double[] arr = {7.5, 7.0, 8.0};
        double[] arr1 = {8.5, 6.0, 7.5};
        double[] arr2 = {7.5, 8.0, 9.0};
        Student s1 = new Student("Sangay", "IT201985001", arr);
        Student s2 = new Student("Bidhya", "IT201985003", arr1);
        Student s3 = new Student("Kelzang", "IT201985065", arr2);
        System.out.printf("%.1f\n",s1.GPA());
        System.out.printf("%.1f\n",s2.GPA());
        System.out.printf("%.1f\n",s3.GPA());
	}
	
}