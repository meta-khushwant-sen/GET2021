import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Vector;


public class CommandPrompt {


public static class Node{
	String key;
	String address;
	Node parent;
	Date date;
	Vector<Node> child = new Vector<>();

	public Node(String key,Node parent){
		this.key=key;
		this.parent=parent;
		date= new Date();
		if(parent==null){
			this.address=key;
		}else{
			this.address=this.parent.address+"\\"+key;
		}
	}
	
}

	public static Node root=new Node("GET:\\",null);
	public static Node currNode=root;
	private void mkdir(String file){
		Node temp=find(root, file);
		if(temp==null){
			currNode.child.add(new Node(file,currNode));
			return;
		}
		System.out.println("Directory already exists");
		return;
	}
	private void cd(String file){
		Node temp=find(currNode, file);
		if(temp==null){
			System.out.println("No Such direcotry exists");
		}else{
			currNode=temp;
		}
	}
	private void bk(){
		if(currNode==root){
			System.out.println("Root doesn't have any parent");
			return;
		}
		currNode=currNode.parent;
	}
	private void findFile(String file){
		List<Node>  files=new ArrayList<>();
		files=findAll(currNode, file);
		if(files.isEmpty()){
			System.out.println("No Such file");
			return;
		}
		for(int i=0;i<files.size();i++){
			System.out.println(files.get(i).date+" "+files.get(i).address);
		}
	}
	private Node find(Node curr,String file){
		if(curr==null){
			return null;
		}
		Node resNode=null;
		Queue<Node> queue= new LinkedList<Node>();
		queue.add(curr);
		while(!queue.isEmpty()){
			int n=queue.size();
			while(n>0){
				Node p=queue.peek();
				queue.remove();
				if(file.equalsIgnoreCase(p.key)&&curr.key.equalsIgnoreCase(p.parent.key)){
					resNode=p;
					break;
				}
				for(int i=0;i<p.child.size();i++){
					queue.add(p.child.get(i));
				}
				n--;
			}
		}
		return resNode;
	}
	public List<Node> findAll(Node curr,String file){
		if(curr==null){
			return null;
		}
		List<Node> resList=new ArrayList<>();
		Queue<Node> currList=new LinkedList<Node>();
		currList.add(curr);
		while(!currList.isEmpty()){
			int n=currList.size();
			while(n>0){
			  Node p=currList.peek();
			  currList.remove();
			  if(file.equalsIgnoreCase(p.key)){
				  resList.add(p);
			  }
			  for(int i=0;i<p.child.size();i++){
				  currList.add(p.child.get(i));
			  }
			  n--;
		  }
	  }
	  return resList;
	
	}
	private void ls(Node curr){
		if(curr==null){
		
		}
		int count=0;
		Queue<Node> files=new LinkedList<>();
		files.add(curr);
		while(!files.isEmpty()){
			int n=files.size();
			while(n>0){
				Node temp=files.peek();
				count++;
				files.remove();
				for(int i=0;i<temp.child.size();i++){
					files.add(temp.child.get(i));
				}
				if(count>1){
				System.out.println(temp.date+" "+temp.address+">");
				}
				n--;
			}
		
		}
	}

	public void print(Node curr){
		if(curr==null){
			
		}
		Queue<Node> files=new LinkedList<>();
		files.add(curr);
		while(!files.isEmpty()){
			int n=files.size();
			while(n>0){
				Node temp=files.peek();
				files.remove();
				System.out.print(temp.address+">");
				for(int i=0;i<temp.child.size();i++){
					files.add(temp.child.get(i));
				}
				System.out.print(" "+temp.address+">");
				n--;
			}
			System.out.println();
		}
	}
public static void main(String args[]){
	CommandPrompt cmd= new CommandPrompt();
	Scanner sc=new Scanner(System.in);
	
    while(true){
    	String answerString="";
    	System.out.print(currNode.address+">");
    	answerString=sc.nextLine();
    	String token[]=answerString.split(" ");
    	switch(token[0]){
    		case "mkdir":cmd.mkdir(token[1]);
    					 break;
    		case "cd"	:cmd.cd(token[1]);
    					 break;
    		case "bk"	:cmd.bk();
    					 break;
    		case "ls"	:cmd.ls(currNode);
    					 break;
    		case "find" :cmd.findFile(token[1]);
    					 break;
    		case "tree":cmd.print(currNode);
    					 break;
    		case "exit":System.exit(0);
    		default:
    			System.out.println("INVALID COMMAND");
    }
    }
}
}
