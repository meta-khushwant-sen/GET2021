package zoo;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Zone {  
	Set<Cage> cages=new HashSet<Cage>();
	String mammal[]={"lion"};
	String reptile[]={"crocodile"};
	String birds[]={"peacock"};
public String zoneName;
public int numOfCages;
public String animalCategory;
public boolean hasPark;
public boolean hasCanteen;
Zone(String zoneName,int num,String aniType,boolean park,boolean canteen){
	this.zoneName=zoneName;
	this.animalCategory=aniType;
	this.numOfCages=num;
	this.hasPark=park;
	this.hasCanteen=canteen;
}
/**
 * adds Cage to a particular zone
 * @param animalType represents the type of animal
 * @param capacity represents capacity of the Cage
 * @param animalCat represents category of the animal
 * @return 1 for success and 0 for failure
 */
int addCage(String animalType,int capacity,String animalCat){
	if(animalCat.equalsIgnoreCase("mammal")){
	if(Arrays.asList(mammal).contains(animalType.toLowerCase())){
		Cage cage=new Cage(animalType,capacity);
		cages.add(cage);
		return 1;
		} 
	}
	if(animalCat.equalsIgnoreCase("reptile")){
		if(Arrays.asList(reptile).contains(animalType.toLowerCase())){
			Cage cage=new Cage(animalType,capacity);
			cages.add(cage);
			return 1;
			} 
		}
	if(animalCat.equalsIgnoreCase("birds")){
		if(Arrays.asList(birds).contains(animalType.toLowerCase())){
			Cage cage=new Cage(animalType,capacity);
			cages.add(cage);
			return 1;
			} 
		}
			
	return 0;
}
}
