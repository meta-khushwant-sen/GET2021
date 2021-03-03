import java.util.Scanner;


public final class Poly {
	private int[] arrPoly;
public float evaluate(float a){
	float result=arrPoly[0];
	for(int i=1;i<arrPoly.length;i++){
		result+=(arrPoly[i]*Math.pow(a, i));
	}
	return result;
}

public int degree(){
	int degree=arrPoly.length-1;
	return degree ;
}
public Poly addPoly(Poly p1,Poly p2){
	Poly newPoly=new Poly();
	int length=Math.max(p1.arrPoly.length,p2.arrPoly.length);
	newPoly.arrPoly=new int[length];
	for(int i=0;i<length;i++){
		if(i<p1.arrPoly.length){
			newPoly.arrPoly[i]+=p1.arrPoly[i];
		}
		if(i<p2.arrPoly.length){
			newPoly.arrPoly[i]+=p2.arrPoly[i];
		}
	}
	return newPoly;
}
public Poly multiPoly(Poly p1,Poly p2){
	Poly newPoly= new Poly();
	int length=p1.arrPoly.length+p2.arrPoly.length-1;
	newPoly.arrPoly=new int[length];
	for(int i=0;i<length;i++){
		newPoly.arrPoly[i]=0;
	}
	for(int i=0;i<p1.arrPoly.length;i++){
		for(int j=0;j<p2.arrPoly.length;j++){
			newPoly.arrPoly[i+j]+=p1.arrPoly[i]*p2.arrPoly[j];
		}
	}
	return newPoly;
}
public Poly createPloy(){
	Poly poly=new Poly();
	Scanner sc= new Scanner(System.in);
	System.out.println("\nEnter the length of polynomial:\n");
	int size=sc.nextInt();
	poly.arrPoly=new int[size];
	System.out.println("\nEnter the value of constant and coeffiecient in increasing order(start with constant then coefficient:\n)");
	for(int i=0;i<size;i++){
		poly.arrPoly[i]=sc.nextInt();
	}
	return poly;
}
public void printPoly(){
	System.out.print(arrPoly[0]);
	for(int i=1;i<arrPoly.length;i++){
		System.out.print(" + "+arrPoly[i]+"x^"+i);
	}
}
public static void main(String args[]){
	Poly polynomial=new Poly();
	Scanner sc= new Scanner(System.in);
	polynomial=polynomial.createPloy();
	while(true){
		System.out.println("\nEnter Your Choice:\n1.Evaluate the polynomial for particular value.\n2.Degree of the polynomial.\n3.Add two polynomials.\n4.Multiply two Polynomials\n5.Exit\n");
		int choice=sc.nextInt();
		switch(choice){
		case 1: System.out.println("\nEnter the value for evaluation\n");
				float value=sc.nextFloat();
				System.out.println("\nValue of polynomial is: "+polynomial.evaluate(value)+"\n");
				break;
		case 2: System.out.println("\nDegree of the polynomial is: "+polynomial.degree()+"\n");
				break;
		case 3: Poly poly1=new Poly();
				Poly poly2=new Poly();
				poly1=poly1.createPloy();
				poly2=poly2.createPloy();
				polynomial=polynomial.addPoly(poly1, poly2);
				polynomial.printPoly();
				break;
		case 4: Poly poly3=new Poly();
				Poly poly4=new Poly();
				poly3=poly3.createPloy();
				poly4=poly4.createPloy();
				polynomial=polynomial.multiPoly(poly3, poly4);
				polynomial.printPoly();
				break;
		case 5: System.exit(0);
		default:
			System.out.println("\nEnter Correct choice:\n");
		}
	}
}
}
