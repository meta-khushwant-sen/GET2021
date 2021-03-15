
import java.util.*;


public class Employee {
	public static HashMap<Integer,Employee> employee=new HashMap<Integer, Employee>();
	public static List<Employee> emp=new LinkedList<Employee>();
	public int empId;
	public String empName;
	public String empAddr;
	public Employee(int id,String name,String address){
		this.empId=id;
		this.empName=name;
		this.empAddr=address;
	}
	public String getName(){
		return this.empName;
	}
	public int getId(){
		return this.empId;
	}
	public String getAddress(){
		return this.empAddr;
	}
	public static void printMap(){
		if(employee.isEmpty()){
			System.out.println("No employee found");
			return;
		}
		Iterator<Map.Entry<Integer, Employee>> itr =employee.entrySet().iterator();
		System.out.println("Employess:");
		System.out.println("EmpId\t\tEmpName\tEmpAdress");
		while(itr.hasNext()){
			Map.Entry<Integer, Employee> entry=itr.next();
			System.out.println(entry.getKey()+"\t\t\t"+entry.getValue().empName+"\t\t\t"+entry.getValue().empAddr);
		}
	}
	public static void printList(){
		if(employee.isEmpty()){
			System.out.println("No employee found in the list");
			return;
		}
		System.out.println("EmpId\t\tEmpName\tEmpAdress");
		for(Employee i:emp){
			System.out.println(i.getId()+"\t\t\t"+i.getName()+"\t\t\t"+i.getAddress());
		}
	}
	public static void main(String args[]){
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter number of employes you want to enter");
		int num=scanner.nextInt();
		for(int i=1;i<=num;i++){
			System.out.println("Enter Employee id");
			int id=scanner.nextInt();
			System.out.println("Enter Employee Name");
			String name=scanner.next();
			System.out.println("Enter Employee address");
			String address=scanner.next();
			Employee E1=new Employee(id,name, address);
			employee.put(E1.empId,E1);
			emp.add(E1);
		}
		System.out.println("Employee Sorted by natural Order");
		Collections.sort(emp,new SortNatural());
		printList();
		System.out.println("Employee sorted by Name Order");
		Collections.sort(emp,new SortByName());
		printList();
		printMap();
	}
}
