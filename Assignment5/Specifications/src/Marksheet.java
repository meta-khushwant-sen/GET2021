import java.util.Scanner;
public class Marksheet {
	private final int passingMarks=40;
	private int numOfStudents;
	private int grades[];
	/**
	 * Constructor
	 * @param num represents numOfStudents
	 */
	private Marksheet(int num){
		if(num<=0){
			System.out.println("Program can't run for "+num+" students");
			System.exit(0);
		}
		this.numOfStudents=num;
		this.grades=new int[num];
	}
	/**
	 * method for calculating average marks
	 * @return average marks in float type
	 */
	private float average(){
		int total=0;
		for(int i=0;i<numOfStudents;i++){
			total+=grades[i];
		}
		return (float)total/numOfStudents;
	}
	/**
	 * method for calculating maximum marks
	 * @return maximum marks
	 */
	private int maximum(){
		int max=grades[0];
		for(int i=1;i<numOfStudents;i++){
			if(grades[i]>max){
				max=grades[i];
			}
		}
		return max;
	}
	/**
	 * method for calculating minimum marks
	 * @return minimum marks
	 */
	private int minimum(){
		int min=grades[0];
		for(int i=1;i<numOfStudents;i++){
			if(grades[i]<min){
				min=grades[i];
			}
		}
		return min;
	}
	/**
	 * method calculate percentage of Students Passed
	 * @return percentage of passed students
	 */
	private float studentPassed(){
		float count=0;
		for(int i=0;i<numOfStudents;i++){
			if(grades[i]>=passingMarks){
				count++;
			}
		}
		System.out.println(count);
		return (count/numOfStudents)*100;
	}
	public static void main(String args[]){
		Marksheet marksheet=new Marksheet(10);
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the marks of the "+marksheet.numOfStudents+" students between 0 and 100:");
		for(int i=0;i<marksheet.numOfStudents;i++){
			marksheet.grades[i]=sc.nextInt();
		}
		while(true){
			System.out.println("Enter your choice:\n1.Average\n2.Maximum\n3.Minimum\n4.Percentage of students passed\n5.exit\n");
			int choice;
			choice=sc.nextInt();
			switch(choice){
			case 1:System.out.println("Average marks: "+String.format("%.02f",marksheet.average()));
					break;
			case 2:System.out.println("Maximum makrs: "+marksheet.maximum());
					break;
			case 3:System.out.println("Minimum marks: "+marksheet.minimum());
					break;
			case 4:System.out.println("% of Students passed: "+String.format("%.02f",marksheet.studentPassed()));
					break;
			case 5:System.exit(0);
			default:
				System.out.println("Enter correct option.");
			}
		}
}
}
