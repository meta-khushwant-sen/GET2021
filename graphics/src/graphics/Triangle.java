package graphics;

import java.sql.Timestamp;
import java.util.Date;

public class Triangle implements Shape {
	public String type;
	public int base;
	public int height;
	public Date date;
	public Timestamp ts;
	public float area;
	public float perimeter;
	public float originDistance;
	Triangle(int x,int y){
		this.base=x;
		this.height=y;
	}
	public Point origin=new Point();
	public void setPoint(int x,int y){
		origin.x=x;
		origin.y=y;
	}
	@Override
	public float getArea() {
		return (float)(0.5*base*height);
		
	}
	@Override
	public float getPerimeter() {
		return (float)(3*base);
	}

	@Override
	public Point getOrigin() {
		return origin;
		
	}

	@Override
	public boolean isPointEnclosed(int x, int y) {
		if((x>=origin.x && x<=(origin.x+base)) && (y>=origin.y && y<=(origin.y+height))){
			return true;
		}
		return false;
		
	}
	@Override
	public String getType() {
		return type;
		
	}
	@Override
	public Timestamp getTimestamp(){
		return ts;
	}
	@Override
	public void setValues(String type) {
		this.type=type;
		this.date=new Date();
		ts=new Timestamp(date.getTime());
		perimeter=this.getPerimeter();
		area=this.getArea();
		this.originDistance=(float)Math.sqrt(Math.pow(origin.x,2)+Math.pow(origin.y, 2));
		
	}
}
