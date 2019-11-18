package CaseStudy1;
//shini
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager
{
	public Connection gtconctn() throws ClassNotFoundException, SQLException
	{
		
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/case1","root","");  
    	if (con != null)
	     {
    		return con;
	    }
	   else
     	{
			return null;
	    }

	}

}
