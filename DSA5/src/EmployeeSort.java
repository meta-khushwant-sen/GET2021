import java.awt.List;
import java.util.Scanner;


public class EmployeeSort {
	public static List head =null;
	public static List end=null;
	public static class List{
		String name;
		int age;
		double salary;
		List next;
		public List(String name,int age,double salary){
			this.name=name;
			this.age=age;
			this.salary=salary;
		}
	}
	public void add(String name,int age, double salary){
		List newNode=new List(name, age, salary);
		newNode.next=head;
		head=newNode;
	}
	public void print(){
		List temp=head;
		System.out.println("Name\t\tAge\t\tSalary");
		while(temp!=null){
			System.out.println(temp.name+"\t\t"+temp.age+"\t\t"+temp.salary);
			temp=temp.next;
		}
	}
	public List partitionLast(List start,List end){
		if(start==end || start==null || end==null){
			return start;
		}
		List pivotPre=start;
		List curr=start;
		double pivot =end.salary;
		int pivotAge=end.age;
		String pivotName=end.name;
		while(start!=end){
			if(start.salary<=pivot){
				if(start.salary==pivot){
					if(start.age>pivotAge){
						pivotPre=curr;
						String name=curr.name;
						int age=curr.age;
						double tempSal=curr.salary;
						curr.salary=start.salary;
						curr.name=start.name;
						curr.age=start.age;
						start.salary=tempSal;
						start.name=name;
						start.age=age;
						curr=curr.next;
						
					}
				}else{
					pivotPre=curr;
					String name=curr.name;
					int age=curr.age;
					double tempSal=curr.salary;
					curr.salary=start.salary;
					curr.name=start.name;
					curr.age=start.age;
					start.salary=tempSal;
					start.name=name;
					start.age=age;
					curr=curr.next;
				}
			}
			start=start.next;
		}
		double tempSal=curr.salary;
		String name=curr.name;
		int age=curr.age;
		curr.salary=pivot;
		curr.age=pivotAge;
		curr.name=pivotName;
		end.salary=tempSal;
		end.age=age;
		end.name=name;
		return pivotPre;
	}
	public void sort(List start,List end){
		if(start==end){
			return;
		}
		List pivotPre=partitionLast(start, end);
		sort(start,pivotPre);
		if(pivotPre!=null && pivotPre==start){
			sort(pivotPre.next,end);
		}else if(pivotPre !=null && pivotPre.next.next!=null){
			sort(pivotPre.next.next, end);
		}
	}
	public void descending (){
		List pre=null;
		List curr=head;
		List next=null;
		while(curr!=null){
			next=curr.next;
			curr.next=pre;
			pre=curr;
			curr=next;
		}
		head=pre;
	}
	public static void main(String args[]){
		Scanner scanner =new Scanner(System.in);
		EmployeeSort e= new EmployeeSort();
		while(true){
			System.out.println("Enter your Choice:\n1.Insert employee\n2.Print sorted list\n3.exit");
			int choice=scanner.nextInt();
			switch(choice){
			case 1:System.out.println("Enter employee name:");
					String name=scanner.next();
					System.out.println("Enter employee age:");
					int age =scanner.nextInt();
					System.out.println("Enter employee salary:");
					int salary =scanner.nextInt();
					e.add(name, age, salary);
					end=head;
					while(end.next!=null){
						end=end.next;
					}
					break;
			case 2: e.sort(head, end);
					e.descending();
					e.print();
				    break;
			case 3:System.exit(0);
					break;
			default:
				System.out.println("Enter correct choice");
			}
		}
	}
}
