package graphics;

import java.util.Date;
import java.util.List;

public class ShapeFactory {
	public static Shape createShape(String shapeType,int param[],Point p){
		Shape shape=null;
		if(shapeType==null){
			return shape;
		}
		if(shapeType.equalsIgnoreCase("circle")){
			if(p.x+param[0]>shape.XMAX || p.y+param[0]>shape.YMAX){
				System.out.println("Point is out of screen");
				System.exit(0);
			}
			shape=new Circle(param[0]);
		}
		if(shapeType.equalsIgnoreCase("square")){
			if(p.x+param[0]>shape.XMAX || p.y+param[0]>shape.YMAX){
				System.out.println("Point is out of screen");
				System.exit(0);
			}
			shape=new Square(param[0]);
		}
		if(shapeType.equalsIgnoreCase("rectangle")){
			if(p.x+param[0]>shape.XMAX || p.y+param[1]>shape.YMAX){
				System.out.println("Point is out of screen");
				System.exit(0);
			}
			shape=new Rectangle(param[0],param[1]);
		}
		if(shapeType.equalsIgnoreCase("triangle")){
			if(p.x+param[0]>shape.XMAX || p.y+param[1]>shape.YMAX){
				System.out.println("Point is out of screen");
				System.exit(0);
			}
			shape=new Triangle(param[0],param[1]);
		}
		if(shapeType.equalsIgnoreCase("Regular polygon")){
			if(p.x+param[0]>shape.XMAX || p.y+param[1]>shape.YMAX){
				System.out.println("Point is out of screen");
				System.exit(0);
			}
			shape=new RegularPolygon(param[0],param[1],param[2]);
		}
		shape.setPoint(p.x, p.y);
		shape.setValues(shapeType);
		return shape;
	}
	
	
}
