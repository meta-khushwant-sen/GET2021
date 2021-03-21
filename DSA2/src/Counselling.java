import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
public class Counselling{
	
	private String str[];
	private int rear,front;
	private final int size=100;
	private static HashMap<String,Double> programs= new HashMap<String, Double>();
	private static HashMap<String,List<IPrograms>> students= new HashMap();
	private static HashMap<String,String> studentPrograms = new HashMap();
	public Counselling() {
		str= new String[size];
		rear=-1;
		front=-1;
	}
	public static Counselling counselling=new Counselling();

	public String dequeue() {
		if(isEmpty()){
			System.out.println("Queue is Empty");
			return null;
		}
		String temp=str[front];
		if(front==rear){
			front=-1;
			rear=-1;
		}
		else if(front==size-1){
			front=0;
		}else{
			front++;
		}
		return temp;
	}

	public void enqueue(String val) {
		if(isFull()){
			System.out.println("Queue is full");
			return;
		}
		if(front==-1){
			front =0;
			rear=0;
		}
		else if(rear==size-1 && front!=0){
			rear=0;
		}else{
			rear++;
		}
		str[rear]=val;
		
	}
	public boolean isEmpty() {
		if(front==-1){
			return true;
		}
		return false;
	}
	public boolean isFull() {
		if((front==0 && rear==size-1) || (rear==(front-1)%(size-1))){
			return true;
		}
		return false;
	}
	public static void getInputStudent(String path){
		try{
			FileInputStream fStream =new FileInputStream(new File(path));
			HSSFWorkbook wb = new HSSFWorkbook(fStream);
			HSSFSheet sheet = wb.getSheetAt(0);
			int rowEnd=Math.max(0,sheet.getLastRowNum());
			for(int i=1;i<=rowEnd;i=i+5){
				int j=1,k;
				Row row=sheet.getRow(i);
				String name=row.getCell(0).getStringCellValue();
				counselling.enqueue(name);
				List<IPrograms> list=new ArrayList<IPrograms>();
				k=i;
				for(int itr=k;itr<k+5;itr++){
					Row row1=sheet.getRow(itr);
					IPrograms iPrograms=new IPrograms();
					iPrograms.name=row1.getCell(1).getStringCellValue();
					iPrograms.rank=j;
					j++;
					list.add(iPrograms);
				}
				students.put(name,list);
			}
		}catch(Exception e){
			System.out.print(e.getMessage());
		}
	}
	public static void getInputProgram(String pathOfFile){
		try{
			FileInputStream fs= new FileInputStream(new File(pathOfFile));
			HSSFWorkbook wb= new HSSFWorkbook();
			HSSFSheet sheet=wb.getSheetAt(0);
			int rowEnd =Math.max(0,sheet.getLastRowNum());
			for(int i=1;i<rowEnd;i++){
				Row row=sheet.getRow(i);
				String name=row.getCell(0).getStringCellValue();
				double cap= row.getCell(1).getNumericCellValue();
				programs.put(name,cap);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public static void setStudent(){
		try{
			FileOutputStream oStream =new FileOutputStream(new File(""));
			HSSFWorkbook wb= new HSSFWorkbook();
			HSSFSheet sheet=wb.createSheet("Program & Students");
			while(!counselling.isEmpty()){
				String name=counselling.dequeue();
				List<IPrograms> list2=students.get(name);
				for(int i=0;i<list2.size();i++){
					IPrograms itr=list2.get(i);
					String pname=itr.name;
					Double cap=programs.get(name);
					if(cap>0){
						cap--;
						programs.put(name,cap);
						studentPrograms.put(name,pname);
						break;
					}
				}
				if(!studentPrograms.containsKey(name)){
					studentPrograms.put(name,null);
				}
				Iterator<Map.Entry<String, String>> iterator=studentPrograms.entrySet().iterator();
				Map.Entry<String,String> it=iterator.next();
				int rowId=1;
				Row rowh=sheet.createRow(0);
				Cell cella=rowh.createCell(0);
				cella.setCellValue("Student Name");
				Cell cellb=rowh.createCell(1);
				cellb.setCellValue("Program allocated");
				while(iterator.hasNext()){
					Row row=sheet.createRow(rowId++);
					Cell cell1=row.createCell(0);
					cell1.setCellValue(it.getKey());
					Cell cell2=row.createCell(1);
					cell2.setCellValue(it.getValue());
				}
				wb.write(oStream);
			}
		}catch(Exception e){
			
		}
	}
	public static void main(String args[]){
		String file="";
		String file1="";
		getInputProgram(file);
		getInputProgram(file1);
		setStudent();
	}

}
