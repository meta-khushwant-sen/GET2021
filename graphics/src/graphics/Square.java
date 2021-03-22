package graphics;

import java.sql.Timestamp;
import java.util.Date;

public class Square implements Shape {
	public String type;
	public int side;
	public Date date;
	public Timestamp ts;
	public float area;
	public float perimeter;
	public float originDistance;
	Square(int s){
		this.side=s;
	}
	public Point origin=new Point();
	public void setPoint(int x,int y){
		origin.x=x;
		origin.y=y;
	}
	@Override
	public float getArea() {
		return (float)(side*side);
		
	}
	@Override
	public float getPerimeter() {
		return (float)(4*side);
	}

	@Override
	public Point getOrigin() {
		return origin;
		
	}

	@Override
	public boolean isPointEnclosed(int x, int y) {
		if((x>=origin.x && x<=(origin.x+side)) && (y>=origin.y && y<=(origin.y+side))){
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
		
	}}
