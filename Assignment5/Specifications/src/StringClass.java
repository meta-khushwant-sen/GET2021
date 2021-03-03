import java.util.Scanner;

public class StringClass {
private int diffAsciiUpperToLower=32;
private String str1;
/**
 * compare two string
 * @param str represents string 1
 * @param str2 represents string 2
 * @return
 */
private int compare(String str,String str2){
	int len1=str.length(); 
	int len2=str2.length();
	if(len1!=len2){
		return 0;
	}
	for(int i=0;i<len1;i++){
		if(str.charAt(i)!=str2.charAt(i)){
			return 0;
		}
	}
	return 1;
}
/**
 * Reverse method for string
 * @return reverse of string
 */
private String reverseString(){
	int length=str1.length();
	String revStr="";  
	for(int i=length-1;i>=0;i--){
		revStr+=str1.charAt(i);
	}
	return revStr;
}
/**
 * Change Uppercase character into Lowercase and vice-versa
 * @return string after the case coversion
 */
private String capsUncaps(){
	int len=str1.length();
	String newStr="";
	for(int i=0;i<len;i++){
		if(str1.charAt(i)>'a' && str1.charAt(i)<'z'){
			newStr+=(char)(str1.charAt(i)-diffAsciiUpperToLower);
		}
		if(str1.charAt(i)>'A' && str1.charAt(i)<'Z'){
			newStr+=(char)(str1.charAt(i)+diffAsciiUpperToLower)
					;
		}
	}
	return newStr;
}
/**
 * Largest Word method
 * @param str represents string
 * @return largest word in the string
 */
private String largestWord(String str){
	int count=0;
	int maxCount=0;
	String largestString="";
	String newStr="";
	for(char c:str.toCharArray()){
		if(c==' '){
			if(count>maxCount){
				largestString=newStr;
				maxCount=count;
				//count=0;
				//newStr="";
			}
			count=0;
			newStr="";
		}else{
			count++;
			newStr+=c;
		}
	}
	return largestString;
}
public static void main(String args[]){
	int result;
	String results;
	Scanner sc=new Scanner(System.in);
	String str="Bring peace to the world";
	String str2="Bring peace to the world";
	
	StringClass strings= new StringClass();

	while(true){
		System.out.println("\nEnter your choice:\n1.Compare\n2.Reverse\n3.Case change\n4.Largest Word\n5.Exit\n");
		int choice=sc.nextInt();
		//sc.useDelimiter("\n");
		switch(choice){
		case 1:	result=strings.compare(str,str2);
				if(result==1){
					System.out.println("\nString matched\n");
				}else{
					System.out.println("\nString did not matched\n");
				}
				break;
		case 2: System.out.println("\nEnter String :\n");
				strings.str1=sc.next();
				results=strings.reverseString();
				System.out.println("\nReverse of String: "+results+"\n");
				break;
		case 3: System.out.println("\nEnter String :\n");
				strings.str1=sc.next();
				results=strings.capsUncaps();
				System.out.println("\nNew String: "+results+"\n");
				break;
		case 4: results=strings.largestWord("Which will be the largest word");
				System.out.println("\nLargest word in String :"+results+"\n");
				break;
		case 5: System.exit(0);
		default:
			System.out.println("\nEnter correct choice\n");
		}
	}
}
}
