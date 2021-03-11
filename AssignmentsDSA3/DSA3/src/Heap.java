import java.util.Scanner;


public class Heap {
	public class Cricket{
		String bowlerName="";
		int balls=0;
		public Cricket(String bowler,int ball) {
			this.bowlerName=bowler;
			this.balls=ball;
		} 
	}
	private Cricket[] heap;
	private int size;
	private int maxsize;
	public Heap(int maxsize){
		this.maxsize=maxsize;
		this.size=0;
		heap= new Cricket[this.maxsize];
		heap[0]=new Cricket("",Integer.MAX_VALUE);
	}
	private int parent (int pos){
		return pos/2;
	}
	private int leftChild(int pos){
		return pos*2;
	}
	private int rightChild(int pos){
		return (2*pos)+1;
	}
	private boolean isLeaf(int pos){
		if(pos>(size/2)&&pos<=size){
			return true;
		}
		return false;
	}
	private void swap(int fpos, int spos){
		Cricket temp=new Cricket("",0);
		temp=heap[fpos];
		heap[fpos]=heap[spos];
		heap[spos]=temp;
	}
	private void heapify(int pos){
		if(isLeaf(pos)){
			return;
		}
		if(heap[pos].balls<heap[leftChild(pos)].balls || heap[pos].balls<heap[rightChild(pos)].balls){
			
			if(heap[leftChild(pos)].balls>heap[rightChild(pos)].balls){
				swap(pos,leftChild(pos));
				heapify(leftChild(pos));
			}else{
				swap(pos,rightChild(pos));
				heapify(rightChild(pos));
			}
		}
	}
   public void insert(String bowler,int balls){
	   heap[++size]=new Cricket(bowler, balls);
	   int curr=size;
	   while(heap[curr].balls>heap[parent(curr)].balls){
		   swap(curr,parent(curr));
		   curr=parent(curr);
	   }
   }
   public String extractMax(){
	   String popped=heap[1].bowlerName;
	   heap[1]=heap[size--];
	   heapify(1);
	   return popped;
   }
   public void print(){
	   for(int i=0;i<heap.length-1;i++){
		   System.out.println(extractMax());
	   }
   }
public static void main(String args[]){
	Heap objHeap=new Heap(5);
	Scanner sc=new Scanner(System.in);
	int balls;
	String bowlerName;
	for(int i=1;i<objHeap.maxsize;i++){
		System.out.println("Name of the bowler and balls");
		bowlerName=sc.next();
		balls=sc.nextInt();
		objHeap.insert(bowlerName, balls);
	}
	objHeap.print();
}
	
}

