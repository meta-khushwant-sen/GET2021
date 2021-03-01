import java.util.Arrays;
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
	Arrays.sort(set);
	Arrays.sort(s.subset);
	//System.out.println("\nsubsetsize:"+s.size(false)+"\n");
	for(int i=0;i<s.size(false);i++){
		int index=Arrays.binarySearch(set,s.subset[i]);
		if(index==-1){
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
	Arrays.sort(s1.subset);
	Arrays.sort(s2.subset);
	newObject.subset=new int[s1.subset.length+s2.subset.length];
	System.arraycopy(s1.subset,0,newObject.subset,0,s1.subset.length);
	System.arraycopy(s2.subset,0,newObject.subset,s1.subset.length,s2.subset.length);
	return newObject;
	
}
public static void main(String args[]){
	intSet originalSet=new intSet();
	intSet s1=new intSet();
	intSet s2=new intSet();
	Scanner sc= new Scanner(System.in);
	while(true){
		System.out.println("\nEnter your Choice:\n1.To check isMember.\n2.Size.\n3.To check isSubset.\n4.Complement.\n5.Union.\n  ");
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
				int iterator=0;
				while(iterator<size){
					int value=sc.nextInt();
					boolean check=s1.isMember(value,false);
					if(!check){
					s1.subset[iterator]=value;
					iterator++;
					}
				}
				System.out.println(originalSet.isSubSet(s1));
				break;
		case 4:originalSet=originalSet.getComplement();
				for(int j=0;j<(originalSet.compliment.length-originalSet.set.length);j++){
					System.out.println("\t"+originalSet.compliment[j]+"\t");
				}
				break;
		case 5:System.out.println("\n.Enter the size of both the subset\n");
				int size1=sc.nextInt();
				int size2=sc.nextInt();
				s1.subset=new int[size1];
				s2.subset=new int[size2];
				System.out.println("\n.Enter the elements of the subset1\n");
				iterator=0;
				while(iterator<size1){
					int value=sc.nextInt();
					boolean check=s1.isMember(value,false);
					if(!check){
					s1.subset[iterator]=value;
					iterator++;
					}
				}
				System.out.println("\n.Enter the elements of the subset2\n");
				iterator=0;
				while(iterator<size2){
					int value=sc.nextInt();
					boolean check=s2.isMember(value,false);
					if(!check){
					s2.subset[iterator]=value;
					iterator++;
					}
				}
				originalSet=originalSet.union(s1, s2);
				for(int i=0;i<originalSet.subset.length;i++){
					System.out.println("\t"+originalSet.subset[i]+"\t");
				}
				break;
		}
	}
} 
}
