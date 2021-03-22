package graphics;

import java.awt.PageAttributes.OriginType;
import java.sql.Timestamp;
import java.util.Date;

public class RegularPolygon implements Shape {
	public String type;
	public int side;
	public int height;
	public int numOfSides;
	public Date date;
	public Timestamp ts;
	public float area;
	public float perimeter;
	public float originDistance;
	RegularPolygon(int s,int h,int nside){
		this.side=s;
		this.height=h;
		this.numOfSides=nside;
	}
	public Point origin=new Point();
	public void setPoint(int x,int y){
		origin.x=x;
		origin.y=y;
	}
	@Override
	public String getType() {
		return type;
		
	}
	@Override
	public float getArea() {

		return (float)(2*(numOfSides*height*side*0.5));
	}
	@Override
	public float getPerimeter() {
		return (float)(2*(numOfSides*side));
	}
	@Override
	public Point getOrigin() {
		return origin;
	}
	@Override
	public boolean isPointEnclosed(int x, int y) {
		if((x>=origin.x && x<=(origin.x+side)) && (y>=origin.y && y<=(origin.y+height))){
			return true;
		}
		return false;
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
	@Override
	public Timestamp getTimestamp() {
		return ts;
	}

}
