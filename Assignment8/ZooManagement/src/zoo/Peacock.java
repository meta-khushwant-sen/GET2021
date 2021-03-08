package zoo;

public class Peacock extends Birds {
	private static char id='0';
	
Peacock(String name,int age,int weight){
	id++;
	this.animalAge=age;
	this.animalId="P"+id;
	this.animalName=name;
	this.animalWeight=weight;
}
	public void getSound(){
		System.out.println("squawk");
	}
}
