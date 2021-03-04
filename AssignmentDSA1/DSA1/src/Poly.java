


public class Poly {
	
	static class Node{
		int x;
		int y;
		Node next;
		
	}
	Node insertNode(Node head,int x,int y){
		Node newNode= new Node();
		newNode.x=x;
		newNode.y=y;
		newNode.next=head;
		head=newNode;
		return head;
		

		
	}
	private  void print (Node head){
		Node temp=head;
		int count=0;
		while(temp!=null){
			if(count==0){
				System.out.print(temp.x);
				temp=temp.next;
				count++;
				continue;
			}
			System.out.print("+"+temp.x+"*x^"+count+"*"+temp.y+"*y^"+count);
			temp=temp.next;
			count++;
		}
	}
	public static void main(String args[]){
		Poly obj=new Poly();
		Node head=null;
		head=obj.insertNode(head,3,4);
		head=obj.insertNode(head,1,2);
		head=obj.insertNode(head,4,0);
		obj.print(head);
		
	}
}
