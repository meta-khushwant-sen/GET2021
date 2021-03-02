
package shoppingmart;
import java.util.ArrayList;
import java.util.Scanner;


public class ShoppingMart {
    private static ArrayList<Item> items= new ArrayList<>();
    private static ArrayList<Item> itemInCart= new ArrayList<>();
    static void entryToMart(){
        System.out.println("Welcome to the Shopping Mart\n Enter your Choice: \n 1. Display all elements in Mart \n 2.Display all elements present in Cart\n 3.Add an item to cart \n 4. Remove an item from the cart \n 5. Displaying the bill \n6.Exit");
   Scanner sc= new Scanner(System.in); 
    int choice= sc.nextInt();  
    switch(choice){
        case 1: displayall(false);
        		break;
        case 2: displayCart();
        		break;
        case 3: addToCart();
        		break;
        case 4: deleteFromCart();
        		break;
        case 5: billing();
        		break;
        case 6: System.exit(0);
        		break;
        default:
            System.out.println("\nEnter the correct option");
         
    }
    }
    static Item searchItem(String itemName,String MartOrCart){
        if(MartOrCart=="Mart"){
         for(Item a: items){
          if(itemName.equals(a.itemName)){
           return a;}
              }
         return null;
        }
        else{
            for(Item a: itemInCart){
          if(itemName.equals(a.itemName)){
           return a;}
              }
         return null;
        }
            
        }
    
    
    static void displayall(boolean fromCart){
     System.out.println("ItemName\t ItemPrice\t ItemQuantity" );
        for(Item a: items){
      System.out.println(a.itemName+"\t \t \t"+a.itemPrice+"\t \t"+a.itemQuantity);
      }
        if(!fromCart)
        entryToMart();
    }
    static void displayCart(){
        System.out.println("ItemName\t ItemPrice\t ItemQuantity" );
        for(Item a: itemInCart){
      System.out.println(a.itemName+"\t \t \t"+a.itemPrice+"\t \t"+a.itemQuantity);
      }
        entryToMart();
    }
    static void addToCart(){
        displayall(true);
        System.out.println("\nEnter the name of the item you want to add to the cart from the listed product\n ");
        System.out.println("Enter the name of the item:\n");
        Scanner sc= new Scanner(System.in);
        String itemToAdd= sc.nextLine();
        System.out.println("Enter the Quantity of the item");
        int itemQuantity=sc.nextInt();
        Item iterator=searchItem(itemToAdd,"Mart");
          if(iterator!=null||iterator.itemQuantity<=0){
          itemInCart.add(new Item(iterator.itemName,iterator.itemPrice,itemQuantity));
          iterator.itemQuantity-=itemQuantity;
          System.out.println(itemQuantity+""+itemToAdd+"Added successfully to the Cart\n");
          entryToMart();
      
      }else{
          System.out.println("No item found with the inserted name\n");
          entryToMart();
          }
       
        
    
}
    static void deleteFromCart(){
            System.out.println("Enter the name of the item you want to delete from the cart.\n ");  
            System.out.println("Enter the name of the item:\n");
            Scanner sc= new Scanner(System.in);
            String itemToDelete= sc.nextLine();
            System.out.println("Enter the Quantity of the item");
            int itemQuantityToDelete=sc.nextInt();
            Item iterator=searchItem(itemToDelete,"Cart");
             if(iterator!=null){
                 if(itemQuantityToDelete==iterator.itemQuantity){
                     itemInCart.remove(iterator);
                     Item iterator2=searchItem(itemToDelete,"Mart");
                     iterator2.itemQuantity+=itemQuantityToDelete;
                 }
                 else{
                     iterator.itemQuantity-=itemQuantityToDelete;
                     Item iterator2=searchItem(itemToDelete,"Mart");
                     iterator2.itemQuantity+=itemQuantityToDelete;
                 }
              
              System.out.println(itemQuantityToDelete+""+itemToDelete+"Removed successfully from the Cart");
              entryToMart();}
              else{
                      System.out.println("No item found with the inserted name");
                      entryToMart();
                      }
      }
      
    
    static void billing(){
        int totalAmount=0;
        System.out.println("ItemName\t ItemPrice\t ItemQuantity" );
        for(Item a: itemInCart){
      System.out.println(a.itemName+"\t \t \t"+a.itemPrice+"\t \t"+a.itemQuantity);
        totalAmount+=(a.itemPrice*a.itemQuantity);
      }
       System.out.println("\nTotal Amount\t\t\t\t\t\t"+totalAmount);
        entryToMart();
    }
    
    public static void main(String[] args) {
   
   items.add(new Item("biscuit",5,50));
   items.add(new Item("chips",10,80));
   items.add(new Item("eggs",5,100));
   items.add(new Item("toys",50,500));
   entryToMart();
   
   
       
    }
    
}
