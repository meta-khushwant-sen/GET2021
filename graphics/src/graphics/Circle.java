package graphics;

import java.util.Date;


public class Circle implements Shape {
	public static float pi=22/7;
	public String type;
	public int radius;
	public float originDistance;
	public float area;
	public float perimeter;
	public Date date; 
	public java.sql.Timestamp ts;
	Circle(int r){
    }
	public Point origin=new Point();
	@Override
	public String getType() {
		return type;
	}
	@Override
	public float getArea() {
		return (float)(pi*radius*radius);
		}
	@Override
	public float getPerimeter() {
		return (float)(pi*2*radius);
		
	}

	@Override
	public Point getOrigin() {
		return origin;
	}

	@Override
	public boolean isPointEnclosed(int x,int y) {
		if((x>=origin.x && x<=(origin.x+radius)) && (y>=origin.y && y<=(origin.y+radius))){
			return true;
		}
		return false;
	}
	@Override
	public void setValues(String type){
		this.type=type;
		this.date=new Date();
		this.ts=new java.sql.Timestamp(this.date.getTime());
		this.perimeter=this.getPerimeter();
		this.area=this.getArea();
		this.originDistance=(float)Math.sqrt(Math.pow(origin.x,2)+Math.pow(origin.y,2));
	}
	public java.sql.Timestamp getTimestamp(){
		return ts;
	}
	
	public void setPoint(int x,int y){
		origin.x=x;
		origin.y=y;
	}

}
