package graphics;

import graphics.Shape.ShapesType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Library {
 public static List<Shape> shapes=new ArrayList<Shape>();
public static void addShape(Shape shape){
	shapes.add(shape);
	System.out.println("Shape added successfully");
}
public static void printShape(){
	if(shapes.isEmpty()){
		System.out.println("No shape present");
	}
	else{
		for(Shape itr:shapes){
			System.out.println(itr.getType());
			System.out.println(itr.getArea());
			System.out.println(itr.getPerimeter());
			System.out.println(itr.getOrigin().x+" "+itr.getOrigin().y);
			System.out.println(itr.getTimestamp());
		}
	}
}
public static void deleteShape(Shape shape){
	if(shapes.isEmpty()){
		System.out.println("No shape present");
		return;
	}
	shapes.remove(shape);
	System.out.println(" shape deleted");
	
}
public static void deleteShapeType(String shapetype){
	if(shapes.isEmpty()){
		System.out.println("No shape present");
		return;
	}
	for(Shape i:shapes){
		if(i.getType()==shapetype){
			shapes.remove(i);
		}
	}
	System.out.println("Shapes deleted successfully");
}
public static void sortByPerimeter(){
	Collections.sort(shapes, new sortByPerimeter());;
	Library.printShape();
}
public static void sortByArea(){
	Collections.sort(shapes, new sortByArea());;
	Library.printShape();
}
public static void sortByTimeStamp(){
	Collections.sort(shapes, new sortByTimeStamp());;
	Library.printShape();
}
}
 