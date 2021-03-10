package classArr;
import java.awt.List;
import java.util.Scanner;
import java.util.Stack;
public class ClassArr {
	private int X;
	private int Y;
ClassArr(int x,int y){
	this.X=x;
	this.Y=y;
}
/**
 * 
 * method finds the length mirror reflection present in the array
 * @param arr represents the array
 * @return length of the mirror reflection
 */
public int maxMirror(int[] arr){
	int length=arr.length;
	if(length==0){
		return 0;
	}
	int maxCount=1;
	boolean flag2=false;
	boolean flag=false;
	for(int i=0;i<length;i++){
		int tempCount=1;
		int count=i;
		for(int j=length-1;j>=0 && (count<length);j--){
			if(arr[count]==arr[j]&& !flag){
				flag=true;
				count++;
				continue;
			}
			if(arr[count]==arr[j]&& flag){
				tempCount++;
				count++;
				maxCount=Math.max(tempCount,maxCount);
				continue;
			}
			if(arr[i]!=arr[j] && flag){
				flag=false;
				count=i;
				tempCount=1;
				continue;
			}
			if(j==count || (j-count)==1){
				flag=false;
				break;
			}
		}
	}
	return maxCount;
}
/**
 * method counts the clumps in the array
 * @param arr represents the array
 * @return number of clumps
 */
private int countClumps(int arr[]){
	int count=0;
	for(int i=0;i<arr.length;i++){
		int flag=0;
		while(i<arr.length-1&&arr[i]==arr[i+1]){
			flag=1;
			i++;
		}
		if(flag==1){
			count++;
		}
	}
	return count;
}
/**
 * method rearranges number such that y can come after x
 * @param arr represents array
 * @return array after being rearranged
 */
private int[] fixXY(int[] arr){
	int j=0;
	int size=arr.length;
	if(size<=0){
		throw new AssertionError("Empty error");
	}
	int yarr[]=new int[size/2];
	int k=0;
	for(int i=0;i<size;i++){
		if(arr[i]==Y){
			yarr[j++]=i;
		}
	}
	j--;
	for(int i=0;i<size-1;i++){
		if(arr[i]==X && arr[i+1]!=Y && arr[i+1]!=X){
			if(k<=j){
				arr[yarr[k++]]=arr[i+1];
				arr[i+1]=Y;
			}else{
				throw new AssertionError("Unequal number of X and Y");
			}
		}else if(arr[i]==X && arr[i+1]==X){
				throw new AssertionError("Two adjacent x's");
			}
		}
	if(arr[size-1]==X){
		throw new AssertionError("X at last index");
	}
	return arr;
}
/**
 * method find index which can split array into two equal sum
 * @param arr  represents array
 * @return index
 */
private int splitArray(int[] arr){
	int leftsum=0;
	int rightsum=0;
	for(int i=0;i<arr.length;i++){
		leftsum+=arr[i];
	}
	for(int i=arr.length-1;i>=0;i--){
		rightsum+=arr[i];
		leftsum-=arr[i];
		if(leftsum==rightsum){
			return i;
		}
		
	}
	return -1;
}
public static void main(String args[]){
	ClassArr obj=new ClassArr(4,5);
	int arr[];
	int size;
	Scanner sc=new Scanner(System.in);
	
	while(true){
		System.out.println("Enter your choice:\n1.MaxMirror\n2.Number of Clumps\n3.Fix XY\n4.Split array\n5.exit");
		int choice=sc.nextInt();
		switch(choice){
		case 1:System.out.println("Enter the size of the array");
				size=sc.nextInt();
				arr=new int[size];
				System.out.println("Enter the elements of the array:");
				for(int i=0;i<size;i++){
					arr[i]=sc.nextInt();
				}
				System.out.println("Max mirror section is: "+obj.maxMirror(arr));
				break;
		case 2:System.out.println("Enter the size of the array");
				size=sc.nextInt();
				arr=new int[size];
				System.out.println("Enter the elements of the array:");
				for(int i=0;i<size;i++){
					arr[i]=sc.nextInt();
				}
				System.out.println("Number of clumps in array: "+obj.countClumps(arr));
				break;
		case 3:System.out.println("Enter the size of the array");
				size=sc.nextInt();
				arr=new int[size];
				System.out.println("Enter the elements of the array:");
				for(int i=0;i<size;i++){
					arr[i]=sc.nextInt();
				}
				obj.fixXY(arr);
				System.out.println("Rearranged array");
				for(int i=0;i<size;i++){
					System.out.println(arr[i]+"\t");
				}
				break;
		case 4:System.out.println("Enter the size of the array");
				size=sc.nextInt();
				arr=new int[size];
				System.out.println("Enter the elements of the array:");
				for(int i=0;i<size;i++){
					arr[i]=sc.nextInt();
				}
				System.out.println("Index splitting array in equal sum: "+obj.splitArray(arr));
				break;
		case 5:System.exit(0);
		default:
			System.out.println("Enter correct choice");
		}
	}
}

}
