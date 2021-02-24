package Fcfs;

import java.util.Scanner;

public class Fcfs {
final static int processAttribute=2;
int numOfProcess;
int time;
int process[][]=new int[100][2];
int complete[]=new int[100];
int wait[]=new int[100];
int turnAround[]=new int[100];

private void completionTime(){
	time=0;
	System.out.println("Completion Time for each process:\n");
	for(int i=0;i<numOfProcess;i++){
			if(time>process[i][0]){
			  complete[i]=time+process[i][1];	
			}
			else{
			  complete[i]=process[i][0]+process[i][1];
			}
			System.out.println("Process "+(i+1)+" is: "+complete[i]);
			time+=process[i][1];
	}
	
	

}
private void waitingTime(boolean fromWait){
	wait[0]=0;
	time=0;
	
	System.out.println("Waiting Time for each process:\n");
	for(int i=0;i<numOfProcess;i++){
		if(time>process[i][0]){
			  wait[i]=time-process[i][0];	
			}
			else{
			  wait[i]=0;
			}
		time+=process[i][1];
		if(fromWait){
		System.out.println("Process "+(i+1)+" is: "+wait[i]);
		}
	}
	
}
private void   turnAroundTime(){
	waitingTime(false);
	System.out.println("\nTurn Around Time for each process:\n");
	for(int i=0;i<numOfProcess;i++){
		turnAround[i]=wait[i]+process[i][1];
		System.out.println("Process "+(i+1)+" is: "+turnAround[i]);
	}
	
}
private void avgWaiting(){
	waitingTime(false);
	int avgWait=0;
	for(int i=0;i<numOfProcess;i++){
		avgWait+=wait[i];
	}
	float favg=avgWait/numOfProcess;
	System.out.println("\nAverage Waiting Time:"+favg);
}
private void maxWait(){
	waitingTime(false);
	int maxWait=wait[0];
	int maxIndex=0;
	for(int i=1;i<numOfProcess;i++){
		if(maxWait<wait[i]){
			maxWait=wait[i];
			maxIndex=i;
		}
	}
	System.out.println("The Process"+(maxIndex+1)+" has the maxixum waiting time of"+maxWait+" seconds");
}
	
public static void main(String args[]){
Fcfs objectProcess= new Fcfs();

System.out.println("Enter the number of process:\n");
Scanner sc= new Scanner(System.in);
objectProcess.numOfProcess=sc.nextInt();
System.out.println("\nEnter the Arrival time and Burst time of the Processes:\n");
for(int i=0;i<objectProcess.numOfProcess;i++){
	for(int j=0;j<processAttribute;j++){
		int randomVariable=sc.nextInt();
		objectProcess.process[i][j]=randomVariable;
	}
}
while(true){
System.out.println("Choos Any Operation\n1.Completion time for each process.\n2.Waiting time for each process\n3.Turn around time for each process.\n4.Average waiting time.\n5.Maximum waiting time period for a porcess.\n6.Exit\n");
int choice=sc.nextInt();
switch(choice){
case 1:objectProcess.completionTime();
	   break;
case 2:objectProcess.waitingTime(true);
	   break;
case 3:objectProcess.turnAroundTime();
	   break;
case 4:objectProcess.avgWaiting();
	   break;
case 5:objectProcess.maxWait();
	   break;
case 6:System.exit(0);
default:
	System.out.println("\nEnter the Correct Option\n");
}
}
}
}
