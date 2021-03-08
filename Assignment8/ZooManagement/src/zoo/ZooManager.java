package zoo;
import java.util.HashSet;

import java.util.Scanner;
import java.util.Set;

public class ZooManager {
 Set<Zone> zones=new HashSet<Zone>();
 static Scanner sc= new Scanner(System.in);
 static boolean isZone=false;
 static boolean isCage=false;
 String animalcat;
 String animalTyp;
 /**
  * Find and prints the zone available for the animal Category
  */
 private void availableZone(){
	 System.out.println("Enter animal Category:");
	animalcat=sc.next();
	animalcat.replaceAll(" ","");
	 System.out.println("Available zones");
	 for(Zone obj:zones){
			if(obj.animalCategory.equalsIgnoreCase(animalcat)){
				isZone=true;
				System.out.println(obj.zoneName);
			}
		}
 }
 /**
  * Find and prints the available Cage in the particular zone object
  * @param obj represents the object of zone
  */
 private void availableCage(Zone obj){
	 System.out.println("Enter animal Type:");
	 animalTyp=sc.next();
	 animalTyp.replaceAll(" ","");
	 System.out.println("Available Cages");
	 for(Cage obj1:obj.cages){
			if(obj1.animalType.equalsIgnoreCase(animalTyp)){
				isCage=true;
				System.out.println(obj1.cageName+" with Capacity "+obj1.capacity);
			}
		}
 }
 /**
  * Searches a particular cage in the zone
  * @param obj represents the zone object
  * @param cageName represents the name of the cage
  * @return object of cage found
  */
 private Cage searchCage(Zone obj,String cageName){
	 for(Cage obj1:obj.cages){
			if(obj1.cageName.equalsIgnoreCase(cageName)&&obj1.animalType.equalsIgnoreCase(animalTyp)){
				return obj1;
			}
		}
	 return null;
 }
 /**
  * searches particular zone in the zoo
  * @param zoneName represents the name of the zone
  * @return object of the zone found
  */
 private Zone searchZone(String zoneName){
	 for(Zone obj:zones){
			if(obj.zoneName.equalsIgnoreCase(zoneName)&&obj.animalCategory.equalsIgnoreCase(animalcat)){
				return obj;
			}
		}
	 return null;
 }
 /**
  * add a new Cage to the zone
  * @param obj represents the object of the zone
  */
 private void addCage(Zone obj){
	 if(obj==null){
		 System.out.println("No such zone Exists");
		 return;
	 }
	 System.out.println("Enter animal Type and then Capacity");
		animalTyp=sc.next();
		animalTyp.replaceAll(" ","");
		int capacity=sc.nextInt();
	 int res=obj.addCage(animalTyp, capacity,obj.animalCategory.toLowerCase());
		if(res==1){
			System.out.println("Cage for "+animalTyp+" with capacity of "+capacity+" added to "+obj.zoneName);
			obj.numOfCages++;
			return;
		}else{
			System.out.println("No such animal is allowed in Zoo");
		}
 }
 /**
  * method for adding animal to a Cage
  * @param obj represents object of a cage
  */
 private void addAnimal(Cage obj){
	 if(obj==null){
		 System.out.println("No such cage available");
		 return;
	 }
	 if(obj.capacity==0){
		 System.out.println("The Cage is already filled");
		 return;
	 }
	 System.out.print("Enter a name for animal");
		String name=sc.next();
		name.replaceAll(" ","");
		System.out.print("Enter age of animal");
		int age=sc.nextInt();
		System.out.print("Enter weight of the animal");
		int weight=sc.nextInt();
		int res=obj.addAnimal(name, age, weight,obj.animalType);
		if(res==1){
			System.out.println(obj.animalType+" named "+name+" added to "+obj.cageName);
		}else{
			System.out.println("No such animal is allowed in Zoo");
		}
	 
 }
 


public static void main(String args[]){
	ZooManager zooObj= new ZooManager();
	String zoneName;
	Zone zone1=new Zone("zone1",4,"Mammal",true,true);
	zone1.addCage("Lion",5,"mammal");
	Zone zone2=new Zone("zone3",10,"Reptile",true,true);
	zone1.addCage("Crocodile",2,"reptile");
	Zone zone3=new Zone("zone4",4,"Mammal",true,true);
	Zone zone4=new Zone("zone5",10,"Reptile",true,true);
	Zone zone5=new Zone("zone6",10,"Birds",true,true);
	Zone zone6=new Zone("zone2",10,"Birds",true,true);
	zooObj.zones.add(zone2);
	zooObj.zones.add(zone1);
	zooObj.zones.add(zone3);
	zooObj.zones.add(zone4);
	zooObj.zones.add(zone5);
	zooObj.zones.add(zone6);
	
	
	while(true){
		System.out.println("Enter your choice:\n1.Add a Cage\n2.Add an Animal\n3.Report the death of an Animal\n4.View existing cage\n5.Exit");
		int choice=sc.nextInt();
		switch(choice){
		case 1: zooObj.availableZone();
				if(!isZone){
					System.out.println("No zone available:");
					break;
				}
				System.out.println("Enter the zone name from above available zones");
				zoneName=sc.next();
				zoneName.replaceAll(" ","");
				Zone obj=zooObj.searchZone(zoneName);
				zooObj.addCage(obj);
				break;
		case 2: zooObj.availableZone();
				if(!isZone){
					System.out.println("No zone available:");
					break;
				}
		 		System.out.println("Enter the zone name from above available zones");
				zoneName=sc.next();
				zoneName.replaceAll(" ","");
				Zone obj1=zooObj.searchZone(zoneName);
				zooObj.availableCage(obj1);
				if(!isCage){
					System.out.println("No Cage available ");
					break;
				}
				System.out.println("Enter the cage name from above available cages");
				String cageName=sc.next();
				cageName.replaceAll(" ","");
				Cage cageObj=zooObj.searchCage(obj1,cageName);
				zooObj.addAnimal(cageObj);
				break;
		case 3: zooObj.availableZone();
				if(!isZone){
					System.out.println("No zone available:");
					break;
				}
				System.out.println("Enter the zone name from above available zones");
				zoneName=sc.next();
				zoneName.replaceAll(" ","");
				Zone zoneObj=zooObj.searchZone(zoneName);
				zooObj.availableCage(zoneObj);
				if(!isCage){
					System.out.println("No Cage available ");
					break;
				}
				System.out.println("Enter the cage name from above available cages");
				String cageName1=sc.next();
				cageName1.replaceAll(" ","");
				Cage cageObj1=zooObj.searchCage(zoneObj,cageName1);
				int result=cageObj1.removeAnimal(cageObj1);
				if(result==1){
					break;
				}
				if(result==2){
					System.out.println("Dead animal removed from the Cage");
					break;
				}
				if(result==3){
				System.out.println("No animal found with that id");
				break;
				}
				break;
		case 4:zooObj.availableZone();
				if(!isZone){
					System.out.println("No zone available:");
					break;
				}
				System.out.println("Enter the zone name from above available zones");
				zoneName=sc.next();
				zoneName.replaceAll(" ","");
				Zone zoneObj2=zooObj.searchZone(zoneName);
				zooObj.availableCage(zoneObj2);
				if(!isCage){
					System.out.println("No Cage available ");
					break;
				}
				break;
		case 5:System.exit(0);
				
		 		 
				
		}
	}
}
}
 