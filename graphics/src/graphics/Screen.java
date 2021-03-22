package graphics;
import java.util.Scanner;
public class Screen {
	static Scanner sc=new Scanner(System.in);
public static void main(String args[]){
	while(true){
	System.out.println("Enter you choice:\n1.Add Shape\n2.Delete a shape\n3.Delete all particular shapes\n4.Sort\n5.List of Shapes");
	int choice=sc.nextInt();
	int dimensions[]=new int[5];
	switch(choice){
	case 1: System.out.println("Enter the type of shape");
			String shapeType=sc.next();
			Shape shape1=null;
			if(shapeType.equalsIgnoreCase("Circle")){
				System.out.println("Enter radius:");
				dimensions[0]=sc.nextInt();
				int x=xPoint();
				int y=yPoint();
				 shape1=ShapeFactory.createShape(shapeType,dimensions,new Point(x, y));
			}
			if(shapeType.equalsIgnoreCase("square")){
				System.out.println("Enter side:");
				dimensions[0]=sc.nextInt();
				int x=xPoint();
				int y=yPoint();
				 shape1=ShapeFactory.createShape(shapeType,dimensions,new Point(x, y));
			}
			if(shapeType.equalsIgnoreCase("Rectangle")){
				System.out.println("Enter width and height:");
				dimensions[0]=sc.nextInt();
				dimensions[1]=sc.nextInt();
				int x=xPoint();
				int y=yPoint();
				shape1=ShapeFactory.createShape(shapeType,dimensions,new Point(x, y));
			}
			if(shapeType.equalsIgnoreCase("triangle")){
				System.out.println("Enter base and height:");
				dimensions[0]=sc.nextInt();
				dimensions[1]=sc.nextInt();
				int x=xPoint();
				int y=yPoint();
				shape1=ShapeFactory.createShape(shapeType,dimensions,new Point(x, y));
			}
			if(shapeType.equalsIgnoreCase("regularPolygon")){
				System.out.println("Enter the number of sides");
				dimensions[2]=sc.nextInt();
				System.out.println("Enter side and height:");
				dimensions[0]=sc.nextInt();
				dimensions[1]=sc.nextInt();
				int x=xPoint();
				int y=yPoint();
				shape1=ShapeFactory.createShape(shapeType,dimensions,new Point(x, y));
			}
			Library.addShape(shape1);
			break;
	case 2: 
	case 3:System.out.println("Enter the type of shape");
			String shapeType1=sc.next();
			Library.deleteShapeType(shapeType1);
			break;
	case 4:System.out.println("Enter your choice :1.byArea\n2.byPerimeter\n3.byTimestamp\n");
			int choice2=sc.nextInt();
			switch(choice2){
			case 1:Library.sortByArea();
					Library.printShape();
					break;
			case 2:Library.sortByPerimeter();
					Library.printShape();
					break;
			case 3:Library.sortByTimeStamp();
					Library.sortByTimeStamp();
					Library.printShape();
			}
			break;
	case 5:Library.printShape();
			break;
			

	}
	}
}
public static int xPoint(){
	System.out.println("Enter the value of x coordinate");
	int x=sc.nextInt();
	return x;
}
public static int yPoint(){
	System.out.println("Enter the value of y coordinate");
	int y=sc.nextInt();
	return y;
}
}
     