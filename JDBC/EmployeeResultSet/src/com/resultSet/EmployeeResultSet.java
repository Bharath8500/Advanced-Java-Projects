package com.resultSet;
import java.sql.*;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

public class EmployeeResultSet {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
	    Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bharath", "root", "Bharath@123");
        PreparedStatement  ps1  = con.prepareStatement("Select * from Employee", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        PreparedStatement  ps2  = con.prepareStatement("Select * from Employee", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        Statement st = con.createStatement(1004, 1007);
        ResultSet rs1 = ps1.executeQuery();
        System.out.println("***********Forward Direction************");
        while(rs1.next()) {
			System.out.println(rs1.getString(1)+" "+rs1.getString(2)+" "+rs1.getInt(3)+" "+rs1.getInt(4));
        	
        }
        System.out.println("**************");
        ResultSet rs5 = ps2.executeQuery();
        rs5.last();
		System.out.println(rs5.getString(1)+" "+rs5.getString(2)+" "+rs5.getInt(3)+" "+rs5.getInt(4));
		System.out.println("************Reverse direction*********");    	
        ResultSet rs2 = ps2.executeQuery();
        rs2.afterLast();
        while(rs2.previous()){
			System.out.println(rs2.getString(1)+" "+rs2.getString(2)+" "+rs2.getInt(3)+" "+rs2.getInt(4));

        }
       

        
	}

}
