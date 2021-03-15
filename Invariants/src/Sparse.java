import java.util.Scanner;

public class Sparse {
	public static Scanner sc=new Scanner(System.in);
	private final int mat[][];
	private final int row,col;
	private final int length;
	public Sparse(int rno,int cno,int[] r,int[] c,int[] val){
		length=r.length;
		row=rno;
		col=cno;
		mat =new int[length][3];
		for(int i=0;i<length;i++){
			mat[i][0]=r[i];
			mat[i][1]=c[i];
			mat[i][2]=val[i];
		}
	}
	public Sparse add(Sparse s){
		if(this.row!=s.row || this.col!=s.col){
			System.out.println("Matrices can't be added");
			return null;
		}
		int row[]=new int[this.length+s.length];
		int col[]=new int[this.length+s.length];
		int val[]=new int[this.length+s.length];
		int itr=0;
		int s1pos=0,spos=0;
		while(s1pos<this.length && spos<s.length){
			if(this.mat[s1pos][0]>s.mat[spos][0] || (this.mat[s1pos][0]==s.mat[spos][0] && this.mat[s1pos][1]>s.mat[spos][1])){
				row[itr]=s.mat[spos][0];
				col[itr]=s.mat[spos][1];
				val[itr]=s.mat[spos][2];
					spos++;
					itr++;
				
			}else if(this.mat[s1pos][0]<s.mat[spos][0] || (this.mat[s1pos][0]==s.mat[spos][0] && this.mat[s1pos][1]<s.mat[spos][1])){
				row[itr]=s.mat[spos][0];
				col[itr]=s.mat[spos][1];
				val[itr]=s.mat[spos][2];
					s1pos++;
					itr++;
			}
			else{
				int addVal=this.mat[s1pos][2]+s.mat[spos][2];
				if(addVal!=0){
					row[itr]=this.mat[s1pos][0];
					col[itr]=this.mat[s1pos][1];
					val[itr]=addVal;
				}
				s1pos++;
				spos++;
				itr++;
			}
		}
		while(s1pos<this.length){
			row[itr]=this.mat[s1pos][0];
			col[itr]=this.mat[s1pos][1];
			val[itr]=this.mat[s1pos][2];
			itr++;
			s1pos++;
		}
		while(spos<this.length){
			row[itr]=this.mat[spos][0];
			col[itr]=this.mat[spos][1];
			val[itr]=this.mat[spos][2];
			itr++;
			spos++;
		}
		Sparse resSparse =new Sparse(this.row,this.col,row,col,val);
		return resSparse;
	}
	public Sparse transpose(){
		int row[]=new int[this.length];
		int col[]=new int[this.length];
		int val[]=new int[this.length];
		int count[]=new int[this.col+1];
		for(int i=1;i<=this.col;i++){
			count[i]=0;
		}
		for(int i=0;i<length;i++){
			count[mat[i][1]]++;
		}
		int [] index = new int[this.col+1];
		index[1]=0;
		for(int i=2;i<=this.col;i++){
			index[i]=index[i-1]+count[i-1];
		}
		for(int i=0;i<length;i++){
			int rpos=index[mat[i][1]]++;
			row[rpos]=mat[i][1];
			col[rpos]=mat[i][0];
			val[rpos]=mat[i][2];
		}
		Sparse trans=new Sparse(this.col,this.row,row,col, val);
		return trans;
	}
	public Sparse multiply(Sparse s2){
		if(this.col!=s2.row){
			System.out.println("Multiplication not possible");
			return null;
		}
		int row[]=new int[this.length*s2.length];
		int col[]=new int[this.length*s2.length];
		int val[]=new int[this.length*s2.length];
		int j=0;
		s2=s2.transpose();
		int s1pos,s2pos;
		for(s1pos=0;s1pos<this.length;){
			int r=mat[s1pos][0];
			for(s2pos=0;s2pos<s2.length;){
				int c=s2.mat[s2pos][0];
				int tempA=s1pos;
				int tempB=s2pos;
				int sum=0;
				while(tempA<this.length && mat[tempA][0]==r && tempB<s2.length && s2.mat[tempB][0]==c){
					if(this.mat[tempA][1]<s2.mat[tempB][1]){
						tempA++;
					}else if(this.mat[tempA][1]>s2.mat[tempB][1]){
						tempB++;
					}
					else{
						sum+=this.mat[tempA++][2]*s2.mat[tempB++][2];
					}
				}
				if(sum!=0){
					row[j]=r;
					col[j]=c;
					val[j]=sum;
					j++;
				}
				while(s2pos<s2.length && s2.mat[s2pos][0]==c){
					s2pos++;
				}
				while(s1pos<this.length && this.mat[s2pos][0]==c){
					s1pos++;
				}
			}
		}
		Sparse resSparse =new Sparse(this.row,s2.col,row,col, val);
		return resSparse;
	}
	public boolean symmetric(Sparse s){
		Sparse sy=s.transpose();
		if(s==sy){
			return true;
		}
		return false;
	}
	public void print(){
		System.out.println("Dimensions:"+row+"x"+col);
		System.out.println("Sparse Matrix:\n Row\tColumn\tValue");
		for(int i=0;i<length && mat[i][2]!=0;i++){
			System.out.println(mat[i][0]+"\t"+mat[i][1]+"\t"+mat[i][2]);
		}
	}
	public static int[] takeInput(int size){
		int[] array=new int[size];
		for(int i=0;i<size;i++){
			array[i]=sc.nextInt();
		}
		return array;
	}
	public static Sparse input(int dimen){
		System.out.println("Enter the number of rows and col having values");
		int size2=sc.nextInt();
		System.out.println("Enter row number having values");
		int[] r2=new int[size2];
		r2=takeInput(size2);
		System.out.println("Enter col number having values");
		int[] c2=new int[size2];
		c2=takeInput(size2);
		System.out.println("Enter the values");
		int[] val2=new int[size2];
		val2=takeInput(size2);
		Sparse s1=new Sparse(dimen,dimen,r2,c2,val2);
		return s1;
	}
public static void main(String args[]){
		
		System.out.println("Enter the dimensions of the matrix:");
		int dimen=sc.nextInt();
		while(true){
			System.out.println("Enter your choice:\n1.add\n2.multiply\n3.transpose\n4.isSymmetric\n5.exit");
			int choice=sc.nextInt();
			switch(choice){
			case 1: Sparse s1=input(dimen);
					Sparse s2=input(dimen);
					Sparse s5=s1.add(s2);
					s5.print();
					break;
			case 2: Sparse s3=input(dimen);
					Sparse s4=input(dimen);
					Sparse s6=s3.multiply(s4);
					s6.print();
					break;
			case 3: Sparse s7=input(dimen);
					Sparse s8=s7.transpose();
					s8.print();
					break;
			case 4: Sparse s9=input(dimen);
					System.out.println("Symmetricity  "+s9.symmetric(s9));
					break;
			}
		}
		
		
	}
	
}
