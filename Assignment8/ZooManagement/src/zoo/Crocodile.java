package zoo;

public class Crocodile extends Reptile {
	private static int id=0;
	
Crocodile(String name,int age,int weight){
	id++;
	this.animalAge=age;
	this.animalId="C"+id;
	this.animalName=name;
	this.animalWeight=weight;
}

	public void getSound(){
		System.out.println("bellow");
	}
}
