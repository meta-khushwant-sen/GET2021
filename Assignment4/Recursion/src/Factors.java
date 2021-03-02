import java.util.Scanner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class Factors {
private int x,y;
/**
 * Calculating HCF
 * @param x first number
 * @param y second number
 * @return HCF of x and y
 */
public int HCF(int x,int y){
	if(y==0){
		return x;
	}
	return HCF(y,x%y);
}

/**
 * Calculating LCM
 * @param x first number
 * @param y second number
 * @return LCM of x and y
 */
@Test
public int LCM(int x,int y){
	int lcm;
	lcm=(x*y)/HCF(x,y);
	assertEquals(525,lcm);
	assertNotEquals(0,lcm);
	return lcm;
	
}
public static void main(String args[]){
	//System.out.println("Enter two numbers:\n");
	Factors factor=new Factors();
	Scanner sc=new Scanner(System.in);
	factor.x=105;
	factor.y=25;
	int hcf;
	while(true){
		System.out.println("\nSelect the operation:\n1.HCF\n2.LCM\n3.Exit");
		int choice=sc.nextInt();
		switch(choice){
		case 1: hcf=factor.HCF(factor.x,factor.y);
				assertEquals(5,hcf);
				assertNotEquals(1,hcf);
				System.out.println(hcf);
				break;
		case 2:System.out.println(factor.LCM(factor.x, factor.y));
				break;
		case 3:System.exit(0);
		}
	}
}
}
