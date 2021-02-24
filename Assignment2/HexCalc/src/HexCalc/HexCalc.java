package HexCalc;

import java.util.Scanner;
import java.lang.Math;


public class HexCalc implements Calc {
	static int count=0;
public static final int hexBase=16;
public static final int diffIntAsciiChar=48;
public static final int diffHexToDecChar=55;
public String add(String firstParameter,String secondParameter){
	firstParameter=hexToDec(firstParameter);
	secondParameter=hexToDec(secondParameter);
	int sum=Integer.parseInt(firstParameter)+Integer.parseInt(secondParameter);
	String requiredAnswer=decToHex(String.valueOf(sum));
	return requiredAnswer;   
}
public String subtract(String firstParameter,String secondParameter){
	firstParameter=hexToDec(firstParameter);
	secondParameter=hexToDec(secondParameter);
	int difference=Integer.parseInt(firstParameter)-Integer.parseInt(secondParameter);
	String requiredAnswer=decToHex(String.valueOf(difference));
	return requiredAnswer;
}
public String multiply(String firstParameter,String secondParameter){
	firstParameter=hexToDec(firstParameter);
	secondParameter=hexToDec(secondParameter);
	int product=Integer.parseInt(firstParameter)*Integer.parseInt(secondParameter);
	String requiredAnswer=decToHex(String.valueOf(product));
	return requiredAnswer;
}
public String divide(String firstParameter,String secondParameter){
	firstParameter=hexToDec(firstParameter);
	secondParameter=hexToDec(secondParameter);
	int quotient=Integer.parseInt(firstParameter)/Integer.parseInt(secondParameter);
	String requiredAnswer=decToHex(String.valueOf(quotient));
	return requiredAnswer;
}
static String hexToDec(String hexValue){
	int length=hexValue.length();
	int decimalValue=0;
	int base=1;
	for(int i=length-1;i>=0;i--){
		if(hexValue.charAt(i)>='0' && hexValue.charAt(i)<='9'){
			decimalValue+=(hexValue.charAt(i)-diffIntAsciiChar)*base;
			}
		else if(hexValue.charAt(i)>='A' && hexValue.charAt(i)<='F'){
			decimalValue+=(hexValue.charAt(i)-diffHexToDecChar)*base;
		}
		base=base*16;
	}

	return String.valueOf(decimalValue);
	
}
static String reverse(String str){
	int length=str.length();
	String revStr="";  
	for(int i=length-1;i>=0;i--){
		revStr+=str.charAt(i);
	}
	return revStr;
}
static String decToHex(String decValue){
	 String hexValue="";
	 int decValueInt=Integer.parseInt(decValue);
	 while(decValueInt!=0){
		 int remainder=0;
		 remainder=decValueInt%hexBase;
		  if(remainder<10){
			 hexValue+=(char)(remainder+diffIntAsciiChar);
		 }
		 else{
			 hexValue+=(char)(remainder+diffHexToDecChar);
		 }
		 decValueInt=decValueInt/16;
	 }
	  return reverse(hexValue);
}
public static void main(String args[]){


Scanner sc= new Scanner(System.in);

System.out.println("\nEnter both the Parameter:\n");
String firstParam=sc.nextLine();
String secondParam=sc.nextLine();
HexCalc object= new HexCalc();
System.out.println("Select the operation you want to Perform \n1.Addition\n2.Subtraction\n3.Multiply\n4.Divide\n");
int  operation=sc.nextInt();
String answer="";
switch(operation){
case 1:
	answer=object.add(firstParam,secondParam);
	break;
case 2:
	answer=object.subtract(firstParam,secondParam);
	break;
case 3:
	answer=object.multiply(firstParam, secondParam);
	break;
case 4:
	answer=object.divide(firstParam, secondParam);
	break;
default:
	System.out.println("Enter Correct option:"); 
}
System.out.println("\n"+answer);
	
}
	
}
