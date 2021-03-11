package zoo;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Cage {
	Set<Animal> animals= new HashSet<Animal>();
	public  static char count='0';
public String cageName;
public String animalType;
public int capacity;
Cage(String animalType){
	count++;
	this.cageName="cage"+count;
	this.animalType=animalType;
	this.capacity=2;
}
/**
 * method add animals to the Cage
 * @param name represents the name of the animal
 * @param age represents the age of the animal
 * @param weight represents the weight of the animal
 * @param animaltyp represents the animal type
 * @return 1 if succeeded else 0
 */
int addAnimal(String name,int age,int weight,String animaltyp){
	if(animaltyp.equalsIgnoreCase("Lion")){
		Lion lion = new Lion(name,age,weight);
		animals.add(lion);
		capacity--;
		return 1;
	
	}
	if(animaltyp.equalsIgnoreCase("Peacock")){
		Peacock peacock = new Peacock(name,age,weight);
		animals.add(peacock);
		capacity--;
		return 1;
	}
	if(animaltyp.equalsIgnoreCase("Crocodile")){
		Crocodile croc = new Crocodile(name,age,weight);
		animals.add(croc);
		capacity--;
		return 1;
	}
	return 0;
}
/**
 * method for removing dead animals from the cage
 * @param obj represents the cage object
 * @return different integer values for different scenarios
 */
int removeAnimal(Cage obj){
	Scanner sc=new Scanner(System.in);
		 if(obj==null){
			 System.out.println("No such cage available");
			 return 0;
		 }
			
			if(obj.animals.size()==0){
				System.out.println("No"+obj.animalType +"presents in this Cage");
				return 1;
			}
			System.out.println("Animals In the Cage:\nAnimalType\t\t\tAnimalName\t\t\t\tAnimalID");
			for(Animal AniObj: obj.animals){
				
				System.out.println(obj.animalType+"\t\t"+AniObj.animalName+"\t\t"+AniObj.animalId);
				
			}
			System.out.print("Enter the id for animal");
			String id=sc.next();
			for(Animal AniObj: obj.animals){
				if(AniObj.animalId.equalsIgnoreCase(id)){
					obj.capacity++;
					return 2;
				}
			}
			
			
		 return 3;
	 }
	

}
