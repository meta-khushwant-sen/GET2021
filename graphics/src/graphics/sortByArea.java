package graphics;

import java.util.Comparator;

public class sortByArea implements Comparator<Shape>{

	public int compare(Shape s1, Shape s2) {
		
		return (int)s1.getArea()-(int)s2.getArea();
	}

}
