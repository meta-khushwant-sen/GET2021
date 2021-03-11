import java.util.Scanner;


public class Main implements PriorityQueue {
	private int[] array;
	private int[] priority;
	private int front,rear;
	boolean repeat=false;
	public Main(int size) {
		this.array= new int[size];
		this.priority= new int[size];
		this.front=-1;
		this.rear=-1;
		
	}
	@Override
	public void add(int val,int prior) {
		int size=array.length;
		if(rear==size-1&&front==0||(repeat&&front==rear+1)){
			System.out.println("Queue is full");
			return;
		}
		if(rear==size-1){
			repeat=true;
			rear=-1;
		} 
		if(rear==-1&&front==-1){
			front=0;
		}
		rear++;
		array[rear]=val;
		priority[rear]=prior;
		System.out.println("element successfully added");
		return;
		
	}

	@Override
	public int remove() {
		if(front==-1||(!repeat&&front==rear+1)){
			System.out.println("Queue is empty");
			return -1;
		}
		int maxpriority=priority[0];
		int index=0;
		for(int i=0;i<priority.length;i++){
			if(maxpriority<priority[i]){
				maxpriority=priority[i];
				index=i;
			}

		}
		int val=array[index];
		front++;
		if(front==array.length){
			front=0;
		}
		return val;
	}
public static void main(String args[]){
	Scanner scanner= new Scanner(System.in);
	Main objMain = new Main(10);
	
	while(true){
		System.out.println("Enter your choice\n1.add an element\n2.remove an element\n3.exit");
		int choice=scanner.nextInt();
	switch(choice){
	case 1:System.out.println("Enter the element:");
		   int element=scanner.nextInt();
		   System.out.println("Enter the priority");
		   int prior=scanner.nextInt();
		   objMain.add(element, prior);
		   break;
	case 2:int res= objMain.remove();
	       if(res!=-1){
	    	   System.out.println(res+" removed");
	    	   break;
	       }
	       break;
	}
	}
}
	
}
