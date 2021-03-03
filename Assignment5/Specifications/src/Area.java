import java.util.Scanner;
public class Area {
	private final double pi=3.145926;
	/**
	 * calculate area of circle
	 * @param radii represents radius of the circle
	 * @return area of circle
	 */
	private double circle(double radii){
		return pi*radii*radii;
	}
	/**
	 * calculates area of square
	 * @param width represents side of a square
	 * @return area of the square
	 */
	private double square(double width){
		return width*width;
	}
	/**
	 * calculates area of the rectangle
	 * @param width represents breadth of the rectangle
	 * @param height represents length of the rectangle
	 * @return area of the rectangle
	 */
	private double rectangle(double width,double height){
		return width*height;
	}
	/**
	 * method calculates are of triangle
	 * @param height represents height of the triangle
	 * @param width represents base of the triangle
	 * @return area of the triangle
	 */
	private double triangle(double height,double width){
		return 0.5*height*width;
	}
	public static void main(String args[]){
		double width,height,radii;
		Scanner sc=new Scanner(System.in);
		Area area= new Area();
		while(true){
			System.out.println("Enter your choice:\n1.Area of Circle\n2.Area of Square\n3.Area of rectangle\n4.Area of Triangle.\n5.Exit");
			int choice=sc.nextInt();
			switch(choice){
			case 1:System.out.println("Enter the radius of the circle:");
					radii=sc.nextDouble();
					System.out.println("Area of circle:"+area.circle(radii));
					break;
			case 2:System.out.println("Enter the width of the Square:");
					width=sc.nextDouble();
					System.out.println("Area of square:"+area.square(width));
					break;
			case 3:System.out.println("Enter the width and height of the rectangle:");
					width=sc.nextDouble();
					height=sc.nextDouble();
					System.out.println("Area of rectangle:"+area.rectangle(width,height));
					break;
			case 4:System.out.println("Enter the width and height of the triangle:");
					width=sc.nextDouble();
					height=sc.nextDouble();
					System.out.println("Area of triangle:"+area.triangle(height,width));
					break;
			case 5:System.exit(0);
			default:
				System.out.println("Enter correct choice");
			}
		}
	}
}
