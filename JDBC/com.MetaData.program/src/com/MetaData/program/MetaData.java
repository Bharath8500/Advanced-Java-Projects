package com.MetaData.program;
import java.sql.*;

import javax.sql.RowSet;
public class MetaData {

	public static void main(String[] args) throws SQLException {
    Connection con = DriverManager.getConnection(
    		"jdbc:mysql://localhost/bharath", 
    		"root", "Bharath@123");
    DatabaseMetaData dmd = con.getMetaData();
    System.out.println(dmd.getDriverVersion());
   System.out.println("Database productName: "+dmd.getDatabaseProductName());
   PreparedStatement ps = con.prepareStatement("insert into CustomerInfo values(?,?,?,?,?)");
   PreparedStatement ps1 = con.prepareStatement("Select * from CustomerInfo where cid=?");
   ParameterMetaData pmd = ps.getParameterMetaData();
   System.out.println("The count of parameters from the parameter Statement is: "+pmd.getParameterCount());
   ps1.setInt(1, 1);
   ResultSet rs= ps1.executeQuery();
   ResultSetMetaData rsmd = rs.getMetaData();
   System.out.println("Count of columns in CustomerInfo: "+rsmd.getColumnCount());
   RowSet rowSet = (RowSet) rs.getMetaData();
	}

}
