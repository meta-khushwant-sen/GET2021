package graphics;

import java.util.Comparator;

public class sortByPerimeter implements Comparator<Shape>{

	public int compare(Shape s1, Shape s2) {
		
		return (int)s1.getPerimeter()-(int)s2.getPerimeter();
	}

}
