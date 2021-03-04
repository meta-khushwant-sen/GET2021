
public class LinkedList {

	static class Node{
		int value;
		Node next;
		
	}
	Node insertNode(Node head,int val){
		Node newNode= new Node();
		newNode.value=val;
		newNode.next=head;
		head=newNode;
		return head;
		

		
	}
	/**
	 * Rotates the sublist of a list
	 * @param head represents the head of the list
	 * @param subStart represents start of the sublist
	 * @param subEnd represents end of the sublist
	 * @param subListStart represents start of the sublist after rotation
	 * @param endAfterRot represents end of the subList after rotation
	 * @param preSubList represents the node just before the subList Starts
	 * @param numOfRotation
	 */
	private  void rotateList(Node head,int subStart,int subEnd,int numOfRotation){
		int sizeSubList=subEnd-subStart+1;
		if(numOfRotation>sizeSubList){
			numOfRotation=numOfRotation%sizeSubList;
		}
		if(numOfRotation==0 || sizeSubList==numOfRotation){
			print(head);
			return;
		}
		Node subListStart=null;
		if(subStart==1){
			subListStart=head;
		}
		Node curr=head;
		int count=0;
		Node endAfterRot=null;
		Node preSubListNode=null;
		while(curr!=null){
			count++;
			if(count==subStart-1){
				preSubListNode=curr;
				subListStart=curr.next;
			}
			if(count==subEnd-numOfRotation){
				if(subStart==1){
					endAfterRot=curr;
					head=curr.next;
				}else{
					endAfterRot=curr;
					preSubListNode.next=curr.next;
				}
			
			}
			if(count==subEnd){
				Node postSubList=curr.next;
				curr.next=subListStart;
				endAfterRot.next=postSubList;
				print(head);
				return;
			}
			curr=curr.next;
		}
		
	}
	/**
	 * prints the node of the list
	 * @param head represents head of the list
	 */
	private  void print (Node head){
		Node temp=head;
		while(temp!=null){
			System.out.print(temp.value+"\t");
			temp=temp.next;
		}
		System.out.println("\n");
	}
	/**
	 * detects loop in the list
	 * @param head represents head of the list
	 */
	private void detectLoop(Node head){
		Node slowPointer=head;
		Node fastPointer=head;
		while(slowPointer!=null && fastPointer!=null&& fastPointer.next!=null){
			slowPointer=slowPointer.next;
			fastPointer=fastPointer.next.next;
			if(slowPointer==fastPointer){
				System.out.println("Loop found");
				return;
			}
		}
		System.out.println("Loop not found");
	}
	
	public static void main(String args[]){
		LinkedList ll=new LinkedList();
			Node head=null;
			head=ll.insertNode(head,60);
			head=ll.insertNode(head,50);
			head=ll.insertNode(head,40);
			head=ll.insertNode(head,30);
			head=ll.insertNode(head,70);
			head=ll.insertNode(head,90);
			ll.print(head); 
			ll.rotateList(head,2,5,1);
			head.next.next.next.next.next=head.next;
			ll.detectLoop(head);
	}
}
