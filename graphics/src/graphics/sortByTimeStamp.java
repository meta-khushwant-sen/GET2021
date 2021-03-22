package graphics;

import java.util.Comparator;


	public class sortByTimeStamp implements Comparator<Shape>{

		public int compare(Shape s1, Shape s2) {
			
			return s1.getTimestamp().compareTo(s2.getTimestamp());
		}

	}

