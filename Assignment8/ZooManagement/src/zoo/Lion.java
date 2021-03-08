package zoo;

public class Lion extends Mammal {
	private static char id='0';
	
Lion(String name,int age,int weight){
	id++;
	this.animalAge=age;
	this.animalId="L"+id;
	this.animalName=name;
	this.animalWeight=weight;
}
	
	public void getSound(){
		System.out.println("Roars");
	}

}
