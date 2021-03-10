import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;


public final class intSet {
	private int[] set=new int[]{1,3,2,9,6,10};
	private int[] subset;
	private int[] compliment=new int[1000];
public boolean isMember(int x,boolean isSet){
	if(isSet){
	Arrays.sort(set);
	int index=Arrays.binarySearch(set, x);
	if(index>=0){
	return true;
	}
	}else{
		Arrays.sort(subset);
		int index=Arrays.binarySearch(subset, x);
		if(index>=0){
		return true;
		}	
	}
	return false;
}
public int size(boolean isSet){
	if(isSet){
		return set.length;
	}
return subset.length;	
}
public boolean isSubSet(intSet s){
	int len1=set.length;
	int len2=s.subset.length;
	if(len2>len1){
		return false;
	}
	HashSet<Integer> hs =new HashSet<Integer>();
	for(int i=0;i<len1;i++){
		hs.add(set[i]);
	}
	for(int i=0;i<len2;i++){
		System.out.println(s.subset[i]);
		if(!hs.contains(s.subset[i])){
			return false;
		}
	}
	return true;
}
public intSet getComplement(){
	intSet newObject=new intSet();
	int count=1;
	int i=0;
	while(i<(compliment.length-set.length)){  
		check:
		if(isMember(count,true)){
			count++;
			break check;
		}else{
			//System.out.println("\n\tValue of count: "+count+"\n");
			newObject.compliment[i]=count;
			count++;
			i++;
		}
	}
	return newObject;
}
public intSet union(intSet s1,intSet s2){
	intSet newObject=new intSet();
	HashSet<Integer>hSet = new HashSet<>();
	for(int i=0;i<s1.subset.length;i++){
		hSet.add(s1.subset[i]);
	}
	for(int i=0;i<s2.subset.length;i++){
		hSet.add(s2.subset[i]);
	}
	Iterator<Integer> iterator=hSet.iterator();
	int i=0;
	newObject.subset= new int[hSet.size()];
	while(iterator.hasNext()){
		newObject.subset[i]=iterator.next();
				i++;
	}
	
	return newObject;
	
}
public static void main(String args[]){
	intSet originalSet=new intSet();
	intSet s1=new intSet();
	intSet s2=new intSet();
	Scanner sc= new Scanner(System.in);
	while(true){
		System.out.println("\nEnter your Choice:\n1.To check isMember.\n2.Size.\n3.To check isSubset.\n4.Complement.\n5.Union.\n6.Exit\n  ");
		int choice=sc.nextInt();
		switch(choice){
		case 1:System.out.println("Enter the element:\n");
				int element=sc.nextInt();
				System.out.println(originalSet.isMember(element,true));
				break;
		case 2:System.out.println("\n"+originalSet.size(true));
				break;
		case 3:System.out.println("\n.Enter the size of the subset\n");
				int size=sc.nextInt();
				s1.subset=new int[size];
				System.out.println("\n.Enter the elements of the subset\n");
				for(int i=0;i<size;i++){
					s1.subset[i]=sc.nextInt();
				}
				
				System.out.println(originalSet.isSubSet(s1));
				break;
		case 4:originalSet=originalSet.getComplement();
				for(int j=0;j<(originalSet.compliment.length-originalSet.set.length);j++){
					System.out.println("\t"+originalSet.compliment[j]+"\t");
				}
				break;
		case 5:System.out.println("\nEnter the size of both the subset\n");
				int size1=sc.nextInt();
				int size2=sc.nextInt();
				s1.subset=new int[size1];
				s2.subset=new int[size2];
				System.out.println("\nEnter the elements of the subset1\n");
				for(int i=0;i<size1;i++){
					s1.subset[i]=sc.nextInt();
				}
				System.out.println("\nEnter the elements of the subset2\n");
				for(int i=0;i<size2;i++){
					s2.subset[i]=sc.nextInt();
				}
				originalSet=originalSet.union(s1, s2);
				for(int i=0;i<originalSet.subset.length;i++){
					System.out.println("\t"+originalSet.subset[i]+"\t");
				}
				break;
		case 6:System.exit(0);
		default: 
			System.out.println("\nEnter the Correct Choice:");
		}
	}
} 
}
