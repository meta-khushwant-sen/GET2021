import java.util.Scanner;


public class Queue implements QueueInterface {
private int front=-1, rear=-1,size;
private int[] queue;
Queue(int c){
	size=c;
	queue= new int[size];
}

@Override
public int dequeue() {
	if(isEmpty()){
		System.out.println("Queue is Empty");
		return -1;
	}
	int temp=queue[front];
	if(front==rear){
		front=-1;
		rear=-1;
	}
	else if(front==size-1){
		front=0;
	}else{
		front++;
	}
	return temp;
}
@Override
public void enqueue(int val) {
	if(isFull()){
		System.out.println("Queue is full");
		return;
	}
	if(front==-1){
		front =0;
		rear=0;
	}
	else if(rear==size-1 && front!=0){
		rear=0;
	}else{
		rear++;
	}
	queue[rear]=val;
	
}
@Override
public boolean isEmpty() {
	if(front==-1){
		return true;
	}
	return false;
}
@Override
public boolean isFull() {
	if((front==0 && rear==size-1) || (rear==(front-1)%(size-1))){
		return true;
	}
	return false;
}
public void display(){
	if(isFull()){
		System.out.println("Queue is full");
		return;
	}
	System.out.println("The queue is");
	if(rear>=front){
		for(int i=front;i<=rear;i++){
			System.out.println(queue[i]);
		}
	}else{
		for(int i=front;i<=size-1;i++){
			System.out.println(queue[i]);
		}
		for(int i=0;i<=rear;i++){
			System.out.println(queue[i]);
		}
	}
}
public static void main(String args[]){
	System.out.println("Enter the size of the queue");
	Scanner scanner=new Scanner(System.in);
	int size=scanner.nextInt();
	Queue qobj=new Queue(size);
	while(true){
		System.out.println("Enter your choice:\n1.add\n2.remove\n3.display");
		int choice=scanner.nextInt();
		switch (choice) {
		case 1: System.out.println("enter the val");
				int val =scanner.nextInt();
				qobj.enqueue(val);
				break;
		case 2:qobj.dequeue();
				break;
		case 3:qobj.display();
				break;
		
		}
				
	}
}
}
