import java.awt.List;
import java.awt.print.Printable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

import com.sun.javafx.geom.AreaOp.AddOp;



public class Graph implements GraphImplementation {
	public int nodes;
	public Vector<Edge> adjacentNodeList[];
	public Graph(int vertex){
		this.nodes=vertex;
		adjacentNodeList= new Vector[nodes];
		for(int i=0;i<nodes;i++){
			adjacentNodeList[i]= new Vector<Edge>();
		}
	}
	public void addEdge(int sourceNode,int destinationNode, int weight){
		boolean anss=true;
		for(int i=0;i<adjacentNodeList[sourceNode].size();i++){
			if(adjacentNodeList[sourceNode].get(i).node==destinationNode){
				anss=false;
				break;
			}
		}
		if(anss){
			adjacentNodeList[sourceNode].add(new Edge(destinationNode, weight));
		}
		boolean ansd=true;
		for(int i=0;i<adjacentNodeList[destinationNode].size();i++){
			if(adjacentNodeList[destinationNode].get(i).node==sourceNode){
				anss=false;
				break;
			}
		}
		if(ansd){
			adjacentNodeList[destinationNode].add(new Edge(sourceNode, weight));
		}
	}
	@Override
	public void isConnected() {
		boolean [] visited=new boolean[nodes];
		depthFirstSearch(0,visited);
		boolean connected =true;
		for(int i=0;i<visited.length;i++){
			if(!visited[i]){
				connected=false;
				break;
			}
		}
		if(connected){
			System.out.println("Graph is connected");
		}
		else{
			System.out.println("Graph is not connected");
		}
		
	}
	public void depthFirstSearch(int sourceNode,boolean[] visited){
		visited[sourceNode]=true;
		for(int i=0;i<adjacentNodeList[sourceNode].size();i++){
			int neighbour=adjacentNodeList[sourceNode].get(i).node;
			if(visited[neighbour]==false){
				depthFirstSearch(neighbour, visited);
			}
		}
	}

	@Override
	public void reachable(int node) {
		boolean[] visited= new boolean[nodes];
		Queue<Integer> queue= new LinkedList<Integer>();
		visited[node]=true;
		queue.add(node);
		while(queue.size()!=0){
			node=queue.poll();
			System.out.print(node+" ");
			Iterator<Edge> iterator=adjacentNodeList[node].listIterator();
			while(iterator.hasNext()){
				int tempNode=iterator.next().node;
				if(!visited[tempNode]){
					visited[tempNode]=true;
					queue.add(tempNode);
				}
			}
			
		}
	}
	public int minimumKey(int key[],boolean mstSet[]){
		int min=Integer.MAX_VALUE;
		int minIndex=-1;
		for(int i=0;i<nodes;i++){
			if(mstSet[i]==false && key[i]<min){
				min=key[i];
				minIndex=i;
			}
		}
		return minIndex;
			
	}
	public void printMst(int parent[]){
		System.out.println("The minimum spanning tree is");
		System.out.println("Edge \t Weight");
		for(int i=1;i<nodes;i++){
			int temp=0;
			for(int j=0;j<adjacentNodeList[i].size();j++){
				if(adjacentNodeList[i].get(j).node==parent[i]){
					temp=adjacentNodeList[i].get(j).weight;
				}
			}
			System.out.println(parent[i]+" - "+i+"\t"+temp);
		}
	}
	@Override
	public void mst() {
		int parent[]=new int[nodes];
		int key[]=new int[nodes];
		boolean mstSet[]=new boolean[nodes];
		for(int i=0;i<nodes;i++){
			key[i]=Integer.MAX_VALUE;
			mstSet[i]=false;
		}
		key[0]=0;
		parent[0]=-1;
		for(int i=0;i<nodes-1;i++){
			int temp=minimumKey(key, mstSet);
			mstSet[temp]=true;
			for(int j=0;j<nodes;j++){
				boolean ans=false;
				int temp2=0;
				for(int k=0;k<adjacentNodeList[temp].size();k++){
					if(adjacentNodeList[temp].get(k).node==j){
						ans=true;
						temp2=adjacentNodeList[temp].get(k).weight;
					}
				}
				if(ans && mstSet[j]==false && temp2<key[j]){
					parent[j]=temp;
					key[j]=temp2;
				}
			}
		}
		printMst(parent);
		
	}
	public void printGraph(){
		for(int i=0;i<nodes;i++){
			for(int j=0;j<adjacentNodeList[i].size();j++){
				System.out.print(adjacentNodeList[i].get(i).node+" "+adjacentNodeList[i].get(i).weight);
			}
			System.out.println();
		}
	}

	@Override
	public void shortestPath(int sourceNode, int destiantionNode) {
		int shortDist[]=new int[nodes];
		boolean added[]=new boolean[nodes];
		for(int i=0;i<nodes;i++){
			shortDist[i]=Integer.MAX_VALUE;
			added[i]=false;
		}
		shortDist[sourceNode]=0;
		int parents[]=new int[nodes];
		parents[sourceNode]=-1;
		for(int i=1;i<nodes;i++){
			int nearestNode=-1;
			int shortDistance=Integer.MAX_VALUE;
			for(int j=0;j<nodes;j++){
				if(!added[j] && shortDist[j]<shortDistance){
					nearestNode=j;
					shortDistance=shortDist[j];
				}
			}
			added[nearestNode]=true;
			for(int k=0;k<nodes;k++){
				int edgeDistance=0;
				for(int n=0;n<adjacentNodeList[nearestNode].size();n++){
					if(adjacentNodeList[nearestNode].get(n).node==k){
						edgeDistance=adjacentNodeList[nearestNode].get(n).weight;
					}
				}
				if(edgeDistance>0 && ((shortDistance+edgeDistance)<shortDist[k])){
					parents[k]=nearestNode;
					shortDist[k]=shortDistance+edgeDistance;
				}
			}
		}
		printSol(sourceNode,shortDist,parents,destiantionNode);
	}
	public void printSol(int sourceNode,int[] shortDist,int[] parents,int destinationNode){
		System.out.println("Node\tDistance\tPath");
		if(sourceNode!=destinationNode){
			System.out.print(sourceNode+" -> "+destinationNode+"\t"+shortDist[destinationNode]+"\t\t");
			printPath(destinationNode,parents);
		}
		System.out.println();
	}
	public void printPath(int destinationNode,int[] parents){
		if(destinationNode==-1){
			return;
		}
		printPath(parents[destinationNode], parents);
		System.out.print(destinationNode+" ");
	}
	public static void main(String args[]){
		Graph graph= new Graph(5);
		graph.addEdge(0,1,2);
		graph.addEdge(0,3,6);
		graph.addEdge(1,2,3);
		graph.addEdge(1,3,8);
		graph.addEdge(1,4,5);
		graph.addEdge(2,4,7);
		graph.addEdge(3,4,9);
		graph.isConnected();
		graph.mst();
		graph.shortestPath(2,3);
		graph.reachable(2);
		
	}

}
