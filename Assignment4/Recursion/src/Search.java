import java.util.Arrays;
import java.util.Scanner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class Search {
	int[] arr={1,14,12,15,2,9,3};
	int[] arrSorted={3,7,9,10,99,102};
	
	/**
	 * Find a value in an array using linear Search.
	 * @param arr array to search, requires that value occurs exactly once
	 *            in arr
	 * @param val value to search for
	 * @return index i such that arr[i] = value
	 */
public int linearSearch(int arr[],int value,int low,int high){
	  if(high<0){
		  return -1;
	  }
	  if(arr[low]==value){
		  return low;
	  }
	  if(arr[high]==value){
		  return high;
	  }
	return linearSearch(arr,value,low+1,high-1);
}
/**
 * Find a value in an array using binary Search.
 * @param arr array to search, requires that value occurs exactly once
 *            in arr
 * @param val value to search for
 * @return index i such that arr[i] = value
 */
public int binarySearch(int arr[], int value,int low,int high){
	if(high>=low){
		int middle=low+high/2;
		if(arr[middle]==value){
			return middle;
		}
		if(arr[middle]<value){
			return binarySearch(arr,value,middle+1,high);
		}else{
			return binarySearch(arr,value,low,middle);
		}
	}
return -1;	
}
/**
 * Showing results for the value found or not.
 * @param index value returned by the searching methods
 */
public void show(int index){
	if(index>=0){
		System.out.println("\nElement found at index "+index);
	}else{
		System.out.println("\nElement not found\n");
	}
}
@Test
public static void main(String args[]){
	int index;
	Scanner sc=new Scanner(System.in);
	Search search=new Search();
	int length=search.arr.length;
	int length2=search.arrSorted.length;
	int value=9;
	while(true){
		System.out.println("\n Select the operation\n1.Linear Search\n2.Binary Search\n3.Exit");
		int choice=sc.nextInt();
		switch(choice){
		case 1:index=search.linearSearch(search.arr,value,0,length-1);
				assertEquals(5,index);
				assertNotEquals(1,index);
				search.show(index);
				break;
		case 2: index=search.binarySearch(search.arrSorted,value,0,length2-1);
				assertEquals(2,index);
				assertNotEquals(1,index);
				search.show(index);
				break;
		case 3:System.exit(0);
		default:
			System.out.println("\n Enter correct input\n");
				
		}
	}
	
}
}
