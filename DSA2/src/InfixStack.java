import java.util.Scanner;
public class InfixStack implements Stack {
	private int top;
	private final int size=100;
	private String arr[];
	public InfixStack() {
		top=-1;
		arr=new String[size];
	}
	@Override
	public String pop() {
		if(this.top==-1){
			System.out.println("Stack is Empty");
			return null;
		}
		return this.arr[this.top--];
	}
	@Override
	public void push(String val) {
		if(this.top>=size-1){
			System.out.println("Stack is full");
			return;
		}
		this.top++;
		this.arr[top]=val;
	}
	public boolean isEmpty(){
		if(this.top==-1){
			return true;
		}
		return false;
	}

	public String peek(){
		if(this.top==-1){
			System.out.println("Stack is Empty");
			return "-1";
		}
		return this.arr[this.top];
	}
	public String evaluate(String expression){
		InfixStack operandStack= new InfixStack();
		InfixStack operatorStack = new InfixStack();
		for(int i=0;i<expression.length();i++){
			if(expression.charAt(i)==' '){
				continue;
			}
			if(expression.charAt(i)>='0' && expression.charAt(i)<='9'){
				String temp="";
				while(i<expression.length() && expression.charAt(i)>='0' && expression.charAt(i)<='9'){
					temp=temp+=expression.charAt(i);
					i++;
				}
				operandStack.push(temp);
				i--;
			}
			else if(expression.charAt(i)=='('){
				operatorStack.push("(");
			}
			else if(expression.charAt(i)==')'){
				while(operatorStack.peek()!="("){
					operandStack.push(evaluateOperator(operatorStack.pop(),Integer.parseInt(operandStack.pop()),Integer.parseInt(operandStack.pop())));
				
				}
				operatorStack.pop();
			}
			else if(expression.charAt(i)=='+' || expression.charAt(i)=='-' || expression.charAt(i)=='*' || 
					expression.charAt(i)=='/' || (expression.charAt(i)=='>' && expression.charAt(i+1)!='=') || (expression.charAt(i)=='<' && expression.charAt(i)!='=') ){
				while(!operatorStack.isEmpty()&& (precedence(Character.toString(expression.charAt(i))))>=precedence(operatorStack.peek())){
					operandStack.push(evaluateOperator(operatorStack.pop(),Integer.parseInt(operandStack.pop()),Integer.parseInt(operandStack.pop())));
				}
				operatorStack.push(Character.toString(expression.charAt(i)));
			}
			else if(expression.charAt(i)=='=' || expression.charAt(i)=='!' || expression.charAt(i)=='&' || expression.charAt(i)=='|'
					|| (expression.charAt(i)=='>' && expression.charAt(i+1)=='=') || (expression.charAt(i)=='<' && expression.charAt(i)!='=')){
				String temp="";
				temp=temp+expression.charAt(i);
				temp=temp+expression.charAt(i+1);
				i=i+1;
				while(!operatorStack.isEmpty() && (precedence(temp)>=precedence(operatorStack.peek()))){
					operandStack.push(evaluateOperator(operatorStack.pop(),Integer.parseInt(operandStack.pop()),Integer.parseInt(operandStack.pop())));
				}
				operatorStack.push(temp);
			}
		}
		while(!operatorStack.isEmpty()){
			operandStack.push(evaluateOperator(operatorStack.pop(),Integer.parseInt(operandStack.pop()),Integer.parseInt(operandStack.pop())));
		}
		return operandStack.pop();
	}
	
	public static int precedence(String op){
		if(op=="(" || op==")"){
			return 7;
		}
		if(op=="*" || op=="/"){
			return 6;
		}
		if(op=="+" || op=="-"){
			return 5;
		}
		if(op=="<" || op==">" || op=="<=" || op==">=" ){
			return 4;
		}
		if(op=="==" || op=="!="){
			return 3;
		}
		if(op=="&&"){
			return 2;
		}
		if(op=="||"){
			return 1;
		}
		return -1;
	}
	
	public static String evaluateOperator(String op,int b,int a){
		switch(op){
		case "+": int c=a+b;
					return Integer.toString(c);
		case "-": int d=a-b;
					return Integer.toString(d);
		case "*": int e=a*b;
					return Integer.toString(e);
		case "/": if(b==0){throw new UnsupportedOperationException("Cannot divide by zero");}
					int f=a/b;
					return Integer.toString(f);
		case "||": return Boolean.toString(intToBool(a)||intToBool(b));
		case "&&": return Boolean.toString(intToBool(a)&&intToBool(b));
		case "==": return Boolean.toString(a==b);
		case "<=": return Boolean.toString(a<=b);
		case ">=": return Boolean.toString(a>=b);
		case "<": return Boolean.toString(a<b);
		case ">": return Boolean.toString(a>b);
		case "!=": return Boolean.toString(a!=b);
		}
		return "#";
		
	}
	public static boolean intToBool(int x){
		if(x>0){
			return true;
		}
		return false;
	}
public static void main(String args[]){
	InfixStack obj=new InfixStack();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the expression");
	String expString=sc.next();
	System.out.println(obj.evaluate(expString));
	sc.close();
}


}
