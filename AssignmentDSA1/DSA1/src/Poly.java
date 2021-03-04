
public class Poly {
	
	static class Node{
		int coeff;
		int xPower;
		int yPower;
		Node next;
		
	}
	/**
	 * insert a node to the list
	 * @param head represents head of the list
	 * @param coeff represents coefficient of the variables
	 * @param x represents x-variable
	 * @param y represents y-variable
	 * @return new head of the list
	 */
	Node insertNode(Node head,int coeff ,int x,int y){
		Node newNode= new Node();
		newNode.coeff=coeff;
		newNode.xPower=x;
		newNode.yPower=y;
		newNode.next=head;
		head=newNode;
		return head;
		

		
	}
	/**
	 * calculates the degree of the polynomial
	 * @param head represents head of the list
	 * @return degree of the polynomial
	 */
	private  int degree (Node head){
		Node temp=head;
		int count=0;
		int degree;
		int maxDegree=0;
		while(temp!=null){
			if(count==0){
				System.out.print(temp.coeff);
				temp=temp.next;
				count++;
				continue;
			}
			System.out.print("+"+temp.coeff+"x^"+temp.xPower+"*y^"+temp.yPower);
			degree=temp.xPower+temp.yPower;
			maxDegree=Math.max(degree,maxDegree);
			temp=temp.next;
			count++;
		}
		return maxDegree;
	}
	public static void main(String args[]){
		Poly obj=new Poly();
		Node head=null;
		head=obj.insertNode(head,3,4,2);//coefficient for degree 3
		head=obj.insertNode(head,1,2,5);
		head=obj.insertNode(head,4,0,0);
		System.out.println("\nDegree of above expression: "+obj.degree(head));
		
	}
}
