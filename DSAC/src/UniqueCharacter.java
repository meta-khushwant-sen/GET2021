import java.util.HashMap;
import java.util.Scanner;



public class UniqueCharacter {
	public static HashMap<String,Integer> cache=new HashMap<String, Integer>();
	static Scanner sc=new Scanner(System.in);
	
	public int countUniqueCharacter(String input){
		boolean[] isItThere= new boolean[Character.MAX_VALUE];
		for(int i=0;i<input.length();i++){
			isItThere[input.charAt(i)]=true;
		}
		int count=0;
		for(int i=0;i<isItThere.length;i++){
			if(isItThere[i]){
				count++;
			}
		}
		return count;
	}
	public void getString(){
		System.out.println("Enter The String:");
		String string=sc.next();
		if(cache.isEmpty()){
			int c=countUniqueCharacter(string);
			cache.put(string,c);
			System.out.print("Number of unique characters are 1:  "+cache.get(string));
		}
		else{
			if(cache.containsKey(string)){
				System.out.print("Number of unique characters are 2:  "+cache.get(string));
			}
			else{
				int c=countUniqueCharacter(string);
				cache.put(string,c);
				System.out.print("Number of unique characters are: "+c);
			}
		}
		
	}
	public static void main(String args[]){
		UniqueCharacter objCharacter=new UniqueCharacter();
		while(true){
			System.out.println("\nEnter your choice:\n1.Count unique character\n2.exit");
			int choice=sc.nextInt();
			switch(choice){
			case 1: objCharacter.getString();
					break;
			case 2: System.exit(0);
			default:
				System.out.println("Enter correct choice");
			}
		}
	}
}
