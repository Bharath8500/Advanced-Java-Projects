package test;
import java.sql.*;
import test.DBInfo;
public class DBConnection 
{
  public static Connection  con =null;
  private DBConnection() { }
	  static {
		  try {
			  con = DriverManager.getConnection(DBInfo.dataBaseURL, DBInfo.userName, DBInfo.paassword);
			  
		  }catch(Exception e){
			  e.printStackTrace();
			  
		  }
	  }
	  public static Connection getConnection() {
		  return con;
	  }
  }

/*Connection con = DriverManager.getConnection(
"jdbc:mysql://localhost:3306/bharath", 
"root", "Bharath@123");*/