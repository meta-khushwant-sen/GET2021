import java.sql.Connection;
import java.sql.DriverManager;


public class MyCon {
	Connection con;
	public Connection config() throws ClassNotFoundException{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/storefront","root","metacube");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return con;
	}

}
