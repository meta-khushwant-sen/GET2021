import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.mysql.cj.jdbc.Blob;


public class DBmain {
	
	public static ResultSet extractData(String query){
		ResultSet rSet;
		try{
			Connection con=new MyCon().config();
			Statement st=con.prepareStatement(query);
			rSet=st.executeQuery(query);
			return rSet;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public void insertImage(int userId){
		
	}
	public static void displaycat() throws SQLException{
		int count;
		String category;
		String queryString="select c1.catName,count(c2.catName) as pcount  from categories c1 inner join categories c2 on c1.catName=c2.parentCat where c1.parentCat='Top Category' group by(c2.parentCat)";
		ResultSet rSet=extractData(queryString);
		while(rSet.next()){
			category=rSet.getString("catName");
			count=rSet.getInt("pcount");
			
			System.out.println(category+"\t"+count);
		}
	}
	
	public static void users(int userid) throws SQLException{
		int orderId;
		int totalCost;
		Date orderDate;
		String queryString="select orderId,Date,totalCost from orders where userId="+userid;
		ResultSet rSet=extractData(queryString);
		while(rSet.next()){
			orderId=rSet.getInt("orderId");
			totalCost=rSet.getInt("totalCost");
			orderDate=rSet.getDate("Date");
			System.out.println(orderId+"\t"+totalCost+"\t\t"+orderDate);
		}
		
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
		users(9);
		displaycat();
		
	}
}
